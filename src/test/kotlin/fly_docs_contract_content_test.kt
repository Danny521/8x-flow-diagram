import contract.content.doc_contract_content
import org.junit.Test

internal class fly_docs_contract_content_test {
    @Test
    fun create_contract_content_doc() {
        doc_contract_content {
            // 定义合约
            contract("预充值合约") {
                // 定义合约的签订方
                val agent = person("甲方", "代理商")
                val flyHigher = person("乙方", "飞得高")

                // 定义履约项并提供证明履约完成的凭证
                fulfillment("预充值", "预充值支付凭证", "30分钟内") {
                    // 甲方产生履约申请凭证
                    request(flyHigher)
                    // 乙方必须在10分钟内完成履约
                    confirm(agent)
                    confirm_failure(flyHigher, fulfillment("预充值作废", "取消充值订单凭证"))
                }

                fulfillment("余额退款", "余额退款凭证", "2个小时") {
                    request(agent)
                    confirm(flyHigher)
                    confirm_failure(agent, prosecute())
                }

                fulfillment("发票开具", "发票", "5个工作日") {
                    request(agent)
                    confirm(flyHigher)
                    confirm_failure(agent, prosecute())
                }

                fulfillment("退票退款", "退票退款凭证", "2个小时") {
                    request(agent)
                    confirm(flyHigher)
                    confirm_failure(agent, prosecute())
                }

                fulfillment("支付购票费用", "支付购票费用凭证", "10分钟") {
                    request(flyHigher)
                    confirm(agent)
                    confirm_failure(flyHigher, fulfillment("购票作废"))
                }
            }

            // 定义合约
            contract("机票订单合约") {
                // 定义合约的签订方
                val buyer = person("甲方", "购票人")
                val saler = person("乙方", "售票人")

                fulfillment("支付", "支付凭证", "30分钟") {
                    request(saler)
                    confirm(buyer)
                    confirm_failure(saler, fulfillment("机票订单作废",))
                }

                fulfillment("出票", "出票凭证", "60分钟内") {
                    request(buyer)
                    confirm(saler)
                    confirm_failure(saler, fulfillment("要求退款"))
                }

                fulfillment("购买行李托运重量", "行李托运重量购买凭证", "30分钟内") {
                    request(buyer)
                    confirm(saler)
                    confirm_failure(buyer, fulfillment("要求退还托运费用"))
                }

                fulfillment("值机", "值机凭证", "5分钟内") {
                    request(buyer)
                    confirm(saler)
                    confirm_failure(buyer, fulfillment("要求乙方给出合理的解释"))
                }

                fulfillment("购买保险", "保险单", "30分钟内") {
                    request(buyer)
                    confirm(saler)
                    confirm_failure(buyer, fulfillment("要求退还保险费用费用"))
                }

                fulfillment("改签", "改签凭证", "10分钟") {
                    request(buyer)
                    confirm(saler)
                    confirm_failure(buyer, fulfillment("要求售票方给出合理的解释"))
                }

                fulfillment("退票退款", "退票退款凭证", "7日内") {
                    request(buyer)
                    confirm(saler)
                    confirm_failure(buyer, prosecute())
                }

                fulfillment("发票开具", "发票", "5日内") {
                    request(buyer)
                    confirm(saler)
                    confirm_failure(buyer, prosecute())
                }
            }
        } export_doc "./flyHigher/contract_content_doc.md"
    }


}
