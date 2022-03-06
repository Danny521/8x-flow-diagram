# 服务与业务能力
## 业务能力表 - 预充值服务上下文
| 角色 | HTTP方法 | URI | 业务能力 | 业务能力服务 |
| --- | --- | --- | --- | --- |
| 预充值用户 | POST | /accounts | 创建预充值服务协议 | 预充值服务上下文 |
| 预充值用户 | GET | /accounts/{aid} | 查看预充值服务协议 | 预充值服务上下文 |
| 思沃租赁 | POST | /accounts/{aid}/precharge-requests | 创建预充值申请 | 预充值服务上下文 |
| 预充值用户 | GET | /accounts/{aid}/precharge-requests | 查看预充值申请列表 | 预充值服务上下文 |
| 预充值用户 | GET | /accounts/{aid}/precharge-requests/{pid} | 查看预充值申请 | 预充值服务上下文 |
| 预充值用户，三方支付 | POST | /accounts/{aid}/precharge-requests/{pid}/confirmation | 创建预充值确认 | 预充值服务上下文 |
| 预充值用户 | GET | /accounts/{aid}/precharge-requests/{pid}/confirmation | 查看预充值确认 | 预充值服务上下文 |
| 预充值用户 | POST | /accounts/{aid}/refunds | 创建余额提现申请 | 预充值服务上下文 |
| 预充值用户 | GET | /accounts/{aid}/refunds | 查看余额提现申请列表 | 预充值服务上下文 |
| 预充值用户 | GET | /accounts/{aid}/refunds/{rid} | 查看余额提现申请 | 预充值服务上下文 |
| 思沃租赁，三方支付 | POST | /accounts/{aid}/refunds/{rid}/confirmation | 余额提现确认 | 预充值服务上下文 |
| 预充值用户 | GET | /accounts/{aid}/refunds/{rid}/confirmation | 查看余额提现确认 | 预充值服务上下文 |
| 思沃租赁 | POST | /accounts/{aid}/payments | 创建推广费用支付申请 | 预充值服务上下文 |
| 预充值用户 | GET | /accounts/{aid}/payments | 查看推广费用支付申请列表 | 预充值服务上下文 |
| 思沃租赁 | GET | /accounts/{aid}/payments/{pid} | 查看推广费用支付申请 | 预充值服务上下文 |
| 预充值用户，三方支付 | POST | /accounts/{aid}/payments/{pid}/confirmation | 创建推广费用支付确认 | 预充值服务上下文 |
| 预充值用户 | GET | /accounts/{aid}/payments/{pid}/confirmation | 查看推广费用支付确认 | 预充值服务上下文 |
| 预充值用户 | POST | /accounts/{aid}/invoices | 创建发票开具申请 | 预充值服务上下文 |
| 预充值用户 | GET | /accounts/{aid}/invoices | 查看发票开具申请列表 | 预充值服务上下文 |
| 预充值用户 | GET | /accounts/{aid}/invoices/{iid} | 查看发票开具申请 | 预充值服务上下文 |
| 思沃租赁，发票代开系统 | POST | /accounts/{aid}/invoices/{iid}/confirmation | 创建发票开具确认 | 预充值服务上下文 |
| 思沃租赁 | GET | /accounts/{aid}/invoices/{iid}/confirmation | 查看发票开具确认 | 预充值服务上下文 |
| 预充值用户 | POST | /accounts/{aid}/bills | 创建账单开具申请 | 预充值服务上下文 |
| 预充值用户 | GET | /accounts/{aid}/bills | 查看账单开具申请列表 | 预充值服务上下文 |
| 预充值用户 | GET | /accounts/{aid}/bills/{bid} | 查看账单开具申请 | 预充值服务上下文 |
| 思沃租赁 | POST | /accounts/{aid}/bills/{bid}/confirmation | 创建账单开具确认 | 预充值服务上下文 |
| 思沃租赁 | GET | /accounts/{aid}/bills/{bid}/confirmation | 查看账单开具确认 | 预充值服务上下文 |


## 业务能力表 - 信息推广服务上下文
| 角色 | HTTP方法 | URI | 业务能力 | 业务能力服务 |
| --- | --- | --- | --- | --- |
| 推广商 | POST | /promotion-proposals | 创建信息推广提案 | 信息推广服务上下文 |
| 广告主、推广报价引擎 | GET | /promotion-proposals | 查看信息推广提案列表 | 信息推广服务上下文 |
| 推广商、推广报价引擎 | GET | /promotion-proposals/{pid} | 查看信息推广提案详情 | 信息推广服务上下文 |
| 广告主 | POST | /promotions | 创建信息推广服务协议 | 信息推广服务上下文 |
| 广告主 | GET | /promotions/{pid} | 查看信息推广服务协议 | 信息推广服务上下文 |
| 推广商 | POST | /promotions/{pid}/request | 创建推广服务申请 | 信息推广服务上下文 |
| 广告主 | GET | /promotions/{pid}/request | 查看推广服务申请详情 | 信息推广服务上下文 |
| 广告主，ADX | POST | /promotions/{pid}/request/confirmation | 创建推广服务确认 | 信息推广服务上下文 |
| 广告主 | GET | /promotions/{pid}/start-request/confirmation | 查看推广服务确认详情 | 信息推广服务上下文 |
| 广告主 | POST | /promotions/{pid}/suspend-requests | 创建暂停推广服务申请 | 信息推广服务上下文 |
| 广告主 | GET | /promotions/{pid}/suspend-requests | 查看暂停推广服务申请列表 | 信息推广服务上下文 |
| 广告主 | GET | /promotions/{pid}/suspend-requests/{sid} | 查看暂停推广服务申请 | 信息推广服务上下文 |
| 推广商，ADX | POST | /promotions/{pid}/suspend-requests/{sid}/confirmation | 创建暂停推广服务确认 | 信息推广服务上下文 |
| 推广商 | GET | /promotions/{pid}/suspend-requests/{sid}/confirmation | 查看暂停推广服务确认详情 | 信息推广服务上下文 |
| 推广商 | POST | /promotions/{pid}/restart-requests | 创建重启推广服务申请 | 信息推广服务上下文 |
| 广告主 | GET | /promotions/{pid}/restart-requests | 查看重启推广服务申请列表 | 信息推广服务上下文 |
| 推广商 | GET | /promotions/{pid}/restart-requests/{rid} | 查看重启推广服务申请 | 信息推广服务上下文 |
| 广告主，ADX | POST | /promotions/{pid}/restart-requests/{rid}/confirmation | 创建重启推广服务确认 | 信息推广服务上下文 |
| 广告主 | GET | /promotions/{pid}/restart-requests/{rid}/confirmation | 查看重启推广服务确认 | 信息推广服务上下文 |
| 广告主 | POST | /promotions/{pid}/statistics | 创建查看推广数据申请 | 信息推广服务上下文 |
| 广告主 | GET | /promotions/{pid}/statistics | 查看查看推广数据申请列表 | 信息推广服务上下文 |
| 广告主 | GET | /promotions/{pid}/statistics/{sid} | 查看查看推广数据申请 | 信息推广服务上下文 |
| 推广商，ADX | POST | /promotions/{pid}/statistics/{sid}/confirmation | 创建查看推广数据确认 | 信息推广服务上下文 |
| 推广商 | GET | /promotions/{pid}/statistics/{sid}/confirmation | 查看查看推广数据确认 | 信息推广服务上下文 |
| 广告主 | POST | /promotions/{pid}/payments | 创建支付申请 | 信息推广服务上下文 |
| 广告主 | GET | /promotions/{pid}/payments | 查看支付申请列表 | 信息推广服务上下文 |
| 广告主 | GET | /promotions/{pid}/payments/{pid} | 查看支付申请 | 信息推广服务上下文 |
| 推广商，三方支付 | POST | /promotions/{pid}/payments/{pid}/confirmation | 创建支付确认 | 信息推广服务上下文 |
| 推广商 | GET | /promotions/{pid}/payments/{pid}/confirmation | 查看支付确认 | 信息推广服务上下文 |



