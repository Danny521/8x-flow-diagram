# 服务与业务能力
## 业务能力表 - 预充值服务上下文
| Role | Method | URI | 业务能力 | 业务能力服务 |
| --- | --- | --- | --- | --- |
| 预充值用户 | POST | /account-requests | 创建预充值账号申请 | 预充值服务上下文 |
| 飞得高 | GET | /account-requests | 获取预充值账号申请列表 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /account-requests/{rid} | 查看预充值账号申请详情 | 预充值服务上下文 |
| 飞得高 | POST | /account-requests/{rid}/confirmation | 创建预充值账号确认 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /account-requests/{rid}/confirmation | 查看预充值账号确认详情 | 预充值服务上下文 |
| 飞得高 | GET | /accounts | 获取预充值账号列表 | 预充值服务上下文 |
| 预充值用户，飞得高 | GET | /accounts/{aid} | 查看预充值账号详情(包含余额) | 预充值服务上下文 |
| 飞得高 | POST | /accounts/{aid}/precharge-requests | 创建预充值申请 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /accounts/{aid}/precharge-requests | 获取预充值申请列表 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /accounts/{aid}/precharge-requests/{pid} | 查看预充值申请详情 | 预充值服务上下文 |
| 预充值用户,三方支付系统 | POST | /accounts/{aid}/precharge-requests/{rid}/confirmation | 创建预充值确认 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /accounts/{aid}/precharge-requests/{rid}/confirmation | 查看预充值确认详情 | 预充值服务上下文 |
| 预充值用户 | POST | /accounts/{aid}/balance-refunds | 创建余额退款申请 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /accounts/{aid}/balance-refunds | 获取余额退款申请列表 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /accounts/{aid}/balance-refunds/{bid} | 查看余额退款申请详情 | 预充值服务上下文 |
| 飞得高,三方支付系统 | POST | /accounts/{aid}/balance-refunds/{bid}/confirmation | 创建余额退款确认 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /accounts/{aid}/balance-refunds/{bid}/confirmation | 查看余额退款确认详情 | 预充值服务上下文 |
| 预充值用户,飞得高 | POST | /accounts/{aid}/ticket-refunds | 创建退票退款申请 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /accounts/{aid}/ticket-refunds | 获取退票退款申请列表 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /accounts/{aid}/ticket-refunds/{tid} | 查看退票退款申请详情 | 预充值服务上下文 |
| 飞得高,三方支付系统 | POST | /accounts/{aid}/ticket-refunds/{tid}/confirmation | 创建退票退款确认 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /accounts/{aid}/ticket-refunds/{tid}/confirmation | 查看退票退款确认详情 | 预充值服务上下文 |
| 飞得高 | POST | /accounts/{aid}/payments | 创建购票费用支付申请 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /accounts/{aid}/payments | 获取购票费用支付申请列表 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /accounts/{aid}/payments/{pid} | 查看购票费用支付申请详情 | 预充值服务上下文 |
| 预充值用户 | POST | /accounts/{aid}/payments/{pid}/confirmation | 创建购票费用支付确认 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /accounts/{aid}/payments/{pid}/confirmation | 查看购票费用支付确认详情 | 预充值服务上下文 |
| 预充值用户 | POST | /accounts/{aid}/invoices | 创建发票开具申请 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /accounts/{aid}/invoices | 获取发票开具申请列表 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /accounts/{aid}/invoices/{iid} | 查看发票开具申请详情 | 预充值服务上下文 |
| 飞得高，发票代开系统 | POST | /accounts/{aid}/invoices/{iid}/confirmation | 创建发票开具确认 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /accounts/{aid}/invoices/{iid}/confirmation | 查看发票开具确认详情 | 预充值服务上下文 |
| 预充值用户 | POST | /accounts/{aid}/bills | 创建发送消费明细申请 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /accounts/{aid}/bills | 获取发送消费明细申请列表 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /accounts/{aid}/bills/{bid} | 查看发送消费明细申请详情 | 预充值服务上下文 |
| 飞得高 | POST | /accounts/{aid}/bills/{bid}/confirmation | 创建发送消费明细确认 | 预充值服务上下文 |
| 预充值用户,飞得高 | GET | /accounts/{aid}/bills/{bid}/confirmation | 查看发送消费明细确认详情 | 预充值服务上下文 |



## 业务能力表 - 机票订单上下文
| Role | Method | URI | 业务能力 | 业务能力服务 |
| --- | --- | --- | --- | --- |
| 购票人 | POST | /order-requests | 创建机票订单申请 | 机票订单上下文 |
| 售票商 | GET | /order-requests | 获取机票订单列表 | 机票订单上下文 |
| 购票人，售票商 | GET | /order-requests/{rid} | 查询机票订单详情 | 机票订单上下文 |
| 售票商 | POST | /order-requests/{rid}/confirmation | 创建机票订单确认 | 机票订单上下文 |
| 购票人，售票商 | GET | /order-requests/{rid}/confirmation | 查看机票订单确认详情 | 机票订单上下文 |
| 售票商 | GET | /orders | 获取机票订单列表 | 机票订单上下文 |
| 购票人，售票商 | GET | /orders/{oid} | 查看机票订单详情 | 机票订单上下文 |
| 购票人，售票商 | POST | /orders/{oid}/ticket | 创建出票申请 | 机票订单上下文 |
| 购票人，售票商 | GET | /orders/{oid}/ticket | 查看出票申请详情 | 机票订单上下文 |
| 售票商 | POST | /orders/{oid}/ticket/confirmation | 创建出票确认 | 机票订单上下文 |
| 购票人，售票商 | GET | /orders/{oid}/ticket/confirmation | 查看出票确认详情 | 机票订单上下文 |
| 购票人，售票商 | POST | /orders/{oid}/baggage-weight | 创建行李托运重量购买申请 | 机票订单上下文 |
| 购票人，售票商 | GET | /orders/{oid}/baggage-weight | 查看行李托运重量购买申请详情 | 机票订单上下文 |
| 售票商 | POST | /orders/{oid}/baggage-weight/confirmation | 创建行李托运重量购买确认 | 机票订单上下文 |
| 购票人，售票商 | GET | /orders/{oid}/baggage-weight/confirmation | 查看行李托运重量购买确认详情 | 机票订单上下文 |
| 购票人，售票商 | POST | /orders/{oid}/refund | 创建退票退款申请 | 机票订单上下文 |
| 购票人，售票商 | GET | /orders/{oid}/refund | 查看退票退款申请详情 | 机票订单上下文 |
| 售票商，三方支付系统 | POST | /orders/{oid}/refund/confirmation | 创建退票退款确认 | 机票订单上下文 |
| 购票人，售票商 | GET | /orders/{oid}/refund/confirmation | 查看退票退款确认详情 | 机票订单上下文 |
| 购票人 | POST | /orders/{oid}/insurance | 创建购买保险申请 | 机票订单上下文 |
| 购票人，售票商 | GET | /orders/{oid}/insurance | 查看购买保险申请详情 | 机票订单上下文 |
| 售票商，三方保险系统 | POST | /orders/{oid}/insurance/confirmation | 创建购买保险确认 | 机票订单上下文 |
| 购票人，售票商 | GET | /orders/{oid}/insurance/confirmation | 查看购买保险确认详情 | 机票订单上下文 |
| 购票人，售票商 | POST | /orders/{oid}/check-in | 创建值机申请 | 机票订单上下文 |
| 购票人，售票商 | GET | /orders/{oid}/check-in | 查看值机申请详情 | 机票订单上下文 |
| 售票商 | POST | /orders/{oid}/check-in/confirmation | 创建值机确认 | 机票订单上下文 |
| 购票人，售票商 | GET | /orders/{oid}/check-in/confirmation | 查看值机确认详情 | 机票订单上下文 |
| 购票人，售票商 | POST | /orders/{oid}/invoice | 创建开具发票申请 | 机票订单上下文 |
| 购票人，售票商 | GET | /orders/{oid}/invoice | 查看开具发票申请详情 | 机票订单上下文 |
| 售票商，发票代开系统 | POST | /orders/{oid}/invoice/confirmation | 创建开具发票确认 | 机票订单上下文 |
| 购票人，售票商 | GET | /orders/{oid}/invoice/confirmation | 查看开具发票确认详情 | 机票订单上下文 |
| 购票人，售票商 | POST | /orders/{oid}/changing | 创建改签申请 | 机票订单上下文 |
| 购票人，售票商 | GET | /orders/{oid}/changing | 查看改签申请详情 | 机票订单上下文 |
| 售票商 | POST | /orders/{oid}/changing/confirmation | 创建改签确认 | 机票订单上下文 |
| 购票人，售票商 | GET | /orders/{oid}/changing/confirmation | 查看改签确认详情 | 机票订单上下文 |
| 售票商 | POST | /orders/{oid}/payment | 创建订单支付申请 | 机票订单上下文 |
| 购票人，售票商 | GET | /orders/{oid}/payment | 查看订单支付申请详情 | 机票订单上下文 |
| 购票人，三方支付系统 | POST | /orders/{oid}/payment/confirmation | 创建订单支付确认 | 机票订单上下文 |
| 购票人，售票商 | GET | /orders/{oid}/payment/confirmation | 查看订单支付确认详情 | 机票订单上下文 |



