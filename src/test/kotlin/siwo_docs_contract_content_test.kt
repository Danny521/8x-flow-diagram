import contract.content.doc_contract_content
import org.junit.Test

internal class siwo_docs_contract_content_test {
    @Test
    fun create_contract_content_doc() {
        doc_contract_content {
            // 定义合约
            contract("预充值合约") {
                // 定义合约的签订方
                val realtor = person("甲方", "房产经纪人")
                val twPlatform = person("乙方", "思沃租房")

                // 定义履约项并提供证明履约完成的凭证
                fulfillment("预充值", "预充值支付凭证", "20分钟内") {
                    // 甲方产生履约申请凭证
                    request(twPlatform)
                    // 乙方必须在10分钟内完成履约
                    confirm(realtor)
                    confirm_failure(twPlatform, fulfillment("取消充值订单", "取消充值订单凭证"))
                }

                fulfillment("余额提现", "余额提现凭证", "3个工作日") {
                    request(realtor)
                    confirm(twPlatform)
                    confirm_failure(realtor, prosecute())
                }

                fulfillment("发票开具", "发票", "5个工作日") {
                    request(realtor)
                    confirm(twPlatform)
                    confirm_failure(realtor, prosecute())
                }

                fulfillment("账单开具", "账单及账单明细", "3个工作日") {
                    request(realtor)
                    confirm(twPlatform)
                    confirm_failure(realtor, prosecute())
                }

                fulfillment("支付推广费用", "支付推广费用凭证", "10分钟") {
                    request(twPlatform)
                    confirm(realtor)
                    confirm_failure(twPlatform, fulfillment("取消推广服务"))
                }
            }

            // 定义合约
            contract("信息推广合约") {
                // 定义合约的签订方
                val realtor = person("甲方", "广告主")
                val twPlatform = person("乙方", "广告商")


                fulfillment("支付", "支付凭证", "20分钟") {
                    request(twPlatform)
                    confirm(realtor)
                    confirm_failure(twPlatform, fulfillment("拒绝提供推广服务",))
                }

                fulfillment("推广服务", "推广服务凭证", "5分钟内") {
                    request(realtor)
                    confirm(twPlatform)
                }

                // 定义履约项并提供证明履约完成的凭证
                fulfillment("暂停推广服务", "暂停推广服务凭证", "5分钟内") {
                    request(realtor)
                    confirm(twPlatform)
                    confirm_failure(realtor, fulfillment("拒绝支付超出的费用", "暂停推广凭证"))
                }

                fulfillment("重启推广服务", "重启推广服务凭证", "5分钟内") {
                    request(realtor)
                    confirm(twPlatform)
                }

                fulfillment("查看推广数据", "三方推广统计数据", "5分钟") {
                    request(realtor)
                    confirm(twPlatform)
                }
            }
        } export_doc "./siwo/contract_content_doc.md"
    }


}
