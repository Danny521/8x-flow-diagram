import doxflow.diagram_8x_flow
import doxflow.dsl.fulfillment
import doxflow.models.diagram.Relationship.Companion.N_TO_ONE
import doxflow.models.diagram.Relationship.Companion.ONE_TO_N
import doxflow.models.diagram.Relationship.Companion.ONE_TO_ONE
import org.junit.Test

internal class fly_diagram_8x_flow_test {
    @Test
    fun siwo_rental_diagram() {
        diagram_8x_flow {
            lateinit var thirdPayContext: fulfillment
            context("预充值服务上下文") {
                val agent = participant_party("代理商") play role_party("预充值用户")
                val flight = participant_party("飞得高") play role_party("航空公司")
                val thirdPay = participant_party("xxx支付") play role_party("第三方支付")

                contract("预充值服务协议", agent, flight) {
                    resource = "order"
                    key_timestamps("签订时间")
                    participant_thing("房屋租赁信息").relate(this)

                    thirdPayContext = fulfillment("第三方支付"){
                        request(agent){
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
                        request(flight) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(agent) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")

                            val evidence = evidence("预充值凭证") {
                                key_timestamps("支付时间")
                                key_data("金额")
                            }
                            evidence play thirdPayContext.confirmation
                        }
                    }
                    fulfillment("余额退款") {
                        resource = "refund-requests"
                        request(agent) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(flight) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")

                            val evidence = evidence("余额退款凭证") {
                                key_timestamps("支付时间")
                                key_data("金额")
                            }
                            evidence play thirdPayContext.confirmation
                        }
                    }
                    fulfillment("购票费用支付") {
                        resource = "pay-requests"
                        request(flight) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(agent) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")

                            val evidence = evidence("购票费用支付凭证", ONE_TO_ONE) {
                                key_timestamps("支付时间")
                                key_data("金额")
                            }
                            evidence play thirdPayContext.confirmation
                        }
                    }
                    fulfillment("发票开具") {
                        resource = "invoice-requests"
                        request(agent) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(flight) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")

                            evidence("发票", ONE_TO_ONE) {
                                key_timestamps("支付时间")
                                key_data("金额")
                            }
                        }
                    }
                    fulfillment("发送消费明细") {
                        resource = "bill-requests"
                        request(agent) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(flight) {
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

            context("信息推广服务上下文") {
                val agent = participant_party("房产经纪人") play role_party("广告主")
                val flight = participant_party("思沃租赁平台") play role_party("广告商")

                contract("信息推广服务协议", agent, flight) {
                    resource = "promotion"
                    relationship = ONE_TO_N
                    key_timestamps("签订时间")
                    participant_thing("房屋租赁信息").relate(this)

                    fulfillment("推广服务") {
                        resource = "start-request"
                        relationship = ONE_TO_N
                        request(flight) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("房屋信息ID")
                        }
                        confirmation(agent) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("房屋信息ID")
                        }
                    }
                    fulfillment("暂停推广服务") {
                        resource = "suspend-request"
                        relationship = ONE_TO_N
                        request(agent) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("房屋信息ID")
                        }
                        confirmation(flight) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("房屋信息ID")
                        }
                    }
                    fulfillment("重启推广服务") {
                        resource = "restart-request"
                        relationship = ONE_TO_N
                        request(flight) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("房屋信息ID")
                        }
                        confirmation(agent) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("房屋信息ID")
                        }
                    }
                    fulfillment("查看推广数据") {
                        resource = "statistic"
                        relationship = ONE_TO_N
                        request(agent) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("房屋信息ID")
                        }
                        confirmation(flight) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("房屋信息ID")
                        }
                    }
                    fulfillment("支付") {
                        resource = "payment"
                        relationship = ONE_TO_N
                        request(agent) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(flight) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                    }
                }
            }
        } export "./siwo/siwo_rental_diagram.png"
    }

    @Test
    fun flight_api_doc() {
        diagram_8x_flow {
            context("预充值服务上下文") {
                val agent = participant_party("代理商") play role_party("预充值用户")
                val flight = role_party("飞得高")

                contract("预充值账号", agent, flight) {
                    resource = "account"
                    relationship = ONE_TO_N
                    key_timestamps("签订时间")
                    participant_thing("房屋租赁信息").relate(this)

                    fulfillment("预充值") {
                        resource = "precharge-request"
                        relationship = ONE_TO_N
                        request(flight) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(agent) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                    }
                    fulfillment("余额退款") {
                        resource = "balance-refundment"
                        relationship = ONE_TO_N
                        request(agent) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(flight) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                    }
                    fulfillment("退票退款") {
                        resource = "ticket-refundment"
                        relationship = ONE_TO_N
                        request(agent) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(flight) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                    }
                    fulfillment("购票费用支付") {
                        resource = "payment"
                        relationship = ONE_TO_N
                        request(flight) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(agent) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                    }
                    fulfillment("发票开具") {
                        resource = "invoice"
                        relationship = ONE_TO_N
                        request(agent) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(flight) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                    }
                    fulfillment("发送消费明细") {
                        resource = "bill"
                        relationship = ONE_TO_N
                        request(agent) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                        confirmation(flight) {
                            key_timestamps("创建时间", "过期时间")
                            key_data("金额")
                        }
                    }
                }
            }

            context("机票订单上下文") {
                val buyer = participant_party("系统用户") play role_party("购票人")
                val saler = participant_party("飞得高") play role_party("售票商")

                contract("机票订单上下文", buyer, saler) {
                    resource = "order"
                    relationship = ONE_TO_N

                    fulfillment("出票") {
                        resource = "ticket"
                        relationship = ONE_TO_ONE
                        request(buyer) {
                        }
                        confirmation(saler) {
                        }
                    }
                    fulfillment("行李托运重量购买") {
                        resource = "baggage-weight"
                        relationship = ONE_TO_ONE
                        request(buyer) {
                        }
                        confirmation(saler) {
                        }
                    }
                    fulfillment("退票退款") {
                        resource = "refundment"
                        relationship = ONE_TO_ONE
                        request(buyer) {
                        }
                        confirmation(saler) {
                        }
                    }
                    fulfillment("购买保险") {
                        resource = "insurance"
                        relationship = ONE_TO_ONE
                        request(buyer) {
                        }
                        confirmation(saler) {
                        }
                    }
                    fulfillment("值机") {
                        resource = "check-in"
                        relationship = ONE_TO_ONE
                        request(buyer) {
                        }
                        confirmation(saler) {
                        }
                    }
                    fulfillment("开具发票") {
                        resource = "invoice"
                        relationship = ONE_TO_ONE
                        request(buyer) {
                        }
                        confirmation(saler) {
                        }
                    }
                    fulfillment("改签") {
                        resource = "changing"
                        relationship = ONE_TO_ONE
                        request(buyer) {
                        }
                        confirmation(saler) {
                        }
                    }
                    fulfillment("订单支付") {
                        resource = "payment"
                        relationship = ONE_TO_ONE
                        request(saler) {
                        }
                        confirmation(buyer) {
                        }
                    }
                }
            }
        } export_doc "./flyHigher/flight_api_doc.md"

    }

}
