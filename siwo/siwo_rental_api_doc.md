# 服务与业务能力
## 业务能力表 - 预充值服务上下文
| 角色 | HTTP方法 | URI | 业务能力 | 业务能力服务 |
| --- | --- | --- | --- | --- |
|  | POST | /accounts/{aid}/account | 创建预充值服务协议 | 预充值服务上下文 |
|  | GET | /accounts/{aid}/account | 查看预充值服务协议 | 预充值服务上下文 |
|  | PUT | /accounts/{aid}/account | 更改预充值服务协议 | 预充值服务上下文 |
|  | DELETE | /accounts/{aid}/account | 取消预充值服务协议 | 预充值服务上下文 |
| 预充值服务上下文广告商 | POST | /accounts/{aid}/account/precharge-requestses | 创建预充值申请 | 预充值服务上下文 |
|  | GET | /accounts/{aid}/account/precharge-requestses | 查看预充值申请列表 | 预充值服务上下文 |
| 预充值服务上下文广告商 | GET | /accounts/{aid}/account/precharge-requestses/{pid} | 查看预充值申请 | 预充值服务上下文 |
| 预充值服务上下文广告商 | PUT | /accounts/{aid}/account/precharge-requestses/{pid} | 更改预充值申请 | 预充值服务上下文 |
| 预充值服务上下文广告商 | DELETE | /accounts/{aid}/account/precharge-requestses/{pid} | 取消预充值申请 | 预充值服务上下文 |
| 预充值服务上下文广告主 | POST | /accounts/{aid}/account/precharge-requestses/{pid}/confirmation | 创建预充值确认 | 预充值服务上下文 |
| 预充值服务上下文广告主 | GET | /accounts/{aid}/account/precharge-requestses/{pid}/confirmation | 查看预充值确认 | 预充值服务上下文 |
| 预充值服务上下文广告主 | PUT | /accounts/{aid}/account/precharge-requestses/{pid}/confirmation | 更改预充值确认 | 预充值服务上下文 |
| 预充值服务上下文广告主 | DELETE | /accounts/{aid}/account/precharge-requestses/{pid}/confirmation | 取消预充值确认 | 预充值服务上下文 |
| 预充值服务上下文广告主 | POST | /accounts/{aid}/account/refund-requests | 创建余额提现申请 | 预充值服务上下文 |
| 预充值服务上下文广告主 | GET | /accounts/{aid}/account/refund-requests | 查看余额提现申请 | 预充值服务上下文 |
| 预充值服务上下文广告主 | PUT | /accounts/{aid}/account/refund-requests | 更改余额提现申请 | 预充值服务上下文 |
| 预充值服务上下文广告主 | DELETE | /accounts/{aid}/account/refund-requests | 取消余额提现申请 | 预充值服务上下文 |
| 预充值服务上下文广告商 | POST | /accounts/{aid}/account/refund-requests/confirmation | 创建余额提现确认 | 预充值服务上下文 |
| 预充值服务上下文广告商 | GET | /accounts/{aid}/account/refund-requests/confirmation | 查看余额提现确认 | 预充值服务上下文 |
| 预充值服务上下文广告商 | PUT | /accounts/{aid}/account/refund-requests/confirmation | 更改余额提现确认 | 预充值服务上下文 |
| 预充值服务上下文广告商 | DELETE | /accounts/{aid}/account/refund-requests/confirmation | 取消余额提现确认 | 预充值服务上下文 |
| 预充值服务上下文广告商 | POST | /accounts/{aid}/account/pay-requests | 创建推广费用支付申请 | 预充值服务上下文 |
| 预充值服务上下文广告商 | GET | /accounts/{aid}/account/pay-requests | 查看推广费用支付申请 | 预充值服务上下文 |
| 预充值服务上下文广告商 | PUT | /accounts/{aid}/account/pay-requests | 更改推广费用支付申请 | 预充值服务上下文 |
| 预充值服务上下文广告商 | DELETE | /accounts/{aid}/account/pay-requests | 取消推广费用支付申请 | 预充值服务上下文 |
| 预充值服务上下文广告主 | POST | /accounts/{aid}/account/pay-requests/confirmation | 创建推广费用支付确认 | 预充值服务上下文 |
| 预充值服务上下文广告主 | GET | /accounts/{aid}/account/pay-requests/confirmation | 查看推广费用支付确认 | 预充值服务上下文 |
| 预充值服务上下文广告主 | PUT | /accounts/{aid}/account/pay-requests/confirmation | 更改推广费用支付确认 | 预充值服务上下文 |
| 预充值服务上下文广告主 | DELETE | /accounts/{aid}/account/pay-requests/confirmation | 取消推广费用支付确认 | 预充值服务上下文 |
| 预充值服务上下文广告主 | POST | /accounts/{aid}/account/invoice-requests | 创建发票开具申请 | 预充值服务上下文 |
| 预充值服务上下文广告主 | GET | /accounts/{aid}/account/invoice-requests | 查看发票开具申请 | 预充值服务上下文 |
| 预充值服务上下文广告主 | PUT | /accounts/{aid}/account/invoice-requests | 更改发票开具申请 | 预充值服务上下文 |
| 预充值服务上下文广告主 | DELETE | /accounts/{aid}/account/invoice-requests | 取消发票开具申请 | 预充值服务上下文 |
| 预充值服务上下文广告商 | POST | /accounts/{aid}/account/invoice-requests/confirmation | 创建发票开具确认 | 预充值服务上下文 |
| 预充值服务上下文广告商 | GET | /accounts/{aid}/account/invoice-requests/confirmation | 查看发票开具确认 | 预充值服务上下文 |
| 预充值服务上下文广告商 | PUT | /accounts/{aid}/account/invoice-requests/confirmation | 更改发票开具确认 | 预充值服务上下文 |
| 预充值服务上下文广告商 | DELETE | /accounts/{aid}/account/invoice-requests/confirmation | 取消发票开具确认 | 预充值服务上下文 |
| 预充值服务上下文广告主 | POST | /accounts/{aid}/account/bill-requests | 创建账单开具申请 | 预充值服务上下文 |
| 预充值服务上下文广告主 | GET | /accounts/{aid}/account/bill-requests | 查看账单开具申请 | 预充值服务上下文 |
| 预充值服务上下文广告主 | PUT | /accounts/{aid}/account/bill-requests | 更改账单开具申请 | 预充值服务上下文 |
| 预充值服务上下文广告主 | DELETE | /accounts/{aid}/account/bill-requests | 取消账单开具申请 | 预充值服务上下文 |
| 预充值服务上下文广告商 | POST | /accounts/{aid}/account/bill-requests/confirmation | 创建账单开具确认 | 预充值服务上下文 |
| 预充值服务上下文广告商 | GET | /accounts/{aid}/account/bill-requests/confirmation | 查看账单开具确认 | 预充值服务上下文 |
| 预充值服务上下文广告商 | PUT | /accounts/{aid}/account/bill-requests/confirmation | 更改账单开具确认 | 预充值服务上下文 |
| 预充值服务上下文广告商 | DELETE | /accounts/{aid}/account/bill-requests/confirmation | 取消账单开具确认 | 预充值服务上下文 |



