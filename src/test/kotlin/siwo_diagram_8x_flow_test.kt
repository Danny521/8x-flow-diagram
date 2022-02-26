import doxflow.diagram_8x_flow
import doxflow.dsl.fulfillment
import doxflow.models.diagram.Relationship.Companion.N_TO_ONE
import doxflow.models.diagram.Relationship.Companion.ONE_TO_N
import doxflow.models.diagram.Relationship.Companion.ONE_TO_ONE
import org.junit.Test

internal class siwo_diagram_8x_flow_test {
    @Test
    fun siwo_rental_diagram() {
        diagram_8x_flow {
            lateinit var thirdPayContext: fulfillment
            context("预充值服务上下文") {
                val realtor = participant_party("房产经纪人") play role_party("广告主")
                val platform = participant_party("思沃租赁平台") play role_party("广告商")
                val thirdPay = participant_party("xxx支付") play role_party("第三方支付")

                contract("预充值服务协议", realtor, platform) {
                    resource = "order"
                    key_timestamps("签订时间")
                    participant_thing("房屋租赁信息").relate(this)

                    thirdPayContext = fulfillment("第三方支付"){
                        request(realtor){
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(thirdPay) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                    }
                    fulfillment("预充值") {
                        resource = "precharge-requests"
                        relationship = ONE_TO_N
                        request(platform) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(realtor) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")

                            val evidence = evidence("预充值凭证") {
                                key_timestamps("支付时间")
                                key_data("金额")
                            }
                            evidence play thirdPayContext.confirmation
                        }
                    }
                    fulfillment("余额提现") {
                        resource = "refund-requests"
                        request(realtor) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(platform) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")

                            val evidence = evidence("余额提现凭证") {
                                key_timestamps("支付时间")
                                key_data("金额")
                            }
                            evidence play thirdPayContext.confirmation
                        }
                    }
                    fulfillment("推广费用支付") {
                        resource = "pay-requests"
                        request(platform) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(realtor) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")

                            val evidence = evidence("推广费用支付凭证", ONE_TO_ONE) {
                                key_timestamps("支付时间")
                                key_data("金额")
                            }
                            evidence play thirdPayContext.confirmation
                        }
                    }
                    fulfillment("发票开具") {
                        resource = "invoice-requests"
                        request(realtor) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(platform) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")

                            evidence("发票", ONE_TO_ONE) {
                                key_timestamps("支付时间")
                                key_data("金额")
                            }
                        }
                    }
                    fulfillment("账单开具") {
                        resource = "bill-requests"
                        request(realtor) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(platform) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")

                            evidence("账单") {
                                key_timestamps("支付时间")
                                key_data("金额")
                                evidence("账单明细", N_TO_ONE) {
                                    key_timestamps("支付时间")
                                    key_data("金额")
                                }
                            }
                        }
                    }
                }
            }
        } export "./siwo/siwo_rental_diagram.png"
    }

    @Test
    fun siwo_rental_api_doc() {
        diagram_8x_flow {
            context("预充值服务上下文") {
                val realtor = participant_party("房产经纪人") play role_party("广告主")
                val platform = participant_party("思沃租赁平台") play role_party("广告商")
                val thirdPay = participant_party("xxx支付") play role_party("第三方支付")

                contract("预充值服务协议", realtor, platform) {
                    resource = "account"
                    relationship = ONE_TO_N
                    key_timestamps("签订时间")
                    participant_thing("房屋租赁信息").relate(this)

                    fulfillment("预充值") {
                        resource = "precharge-requests"
                        relationship = ONE_TO_N
                        request(platform) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(realtor) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                    }
                    fulfillment("余额提现") {
                        resource = "refund-requests"
                        request(realtor) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(platform) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                    }
                    fulfillment("推广费用支付") {
                        resource = "pay-requests"
                        request(platform) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(realtor) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                    }
                    fulfillment("发票开具") {
                        resource = "invoice-requests"
                        request(realtor) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(platform) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                    }
                    fulfillment("账单开具") {
                        resource = "bill-requests"
                        request(realtor) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(platform) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                    }
                }
            }
        } export_doc "./siwo/siwo_rental_api_doc.md"
    }

}
