# 服务与业务能力
## 业务能力表 - 预充值上下文
| Role | Method | URI | 业务能力 | 业务能力服务 |
| --- | --- | --- | --- | --- |
| 预充值用户/飞得高 | POST | /accounts | 申请创建预充值账号 | 预充值服务服务 |
| 飞得高 | GET | /accounts | 获取预充值账号列表 | 预充值服务服务 |
| 预充值用户/飞得高 | GET | /accounts/{aid} | 查看预充值账号详情(包含余额) | 预充值服务服务 |
| 飞得高 | POST | /accounts/{aid}/confirmation | 确认预充值账号 | 预充值服务服务 |
| 预充值用户/飞得高 | POST | /accounts/{aid}/precharge-requests | 申请预充值 | 预充值服务服务 |
| 预充值用户/飞得高/优惠算法 | GET | /accounts/{aid}/precharge-requests | 获取预充值列表 | 预充值服务服务 |
| 预充值用户/飞得高/优惠算法 | GET | /accounts/{aid}/precharge-requests/{pid} | 查看预充值详情 | 预充值服务服务 |
| 预充值用户/三方支付系统 | POST | /accounts/{aid}/precharge-requests/{rid}/confirmation | 确认预充值 | 预充值服务服务 |
| 预充值用户/飞得高 | POST | /accounts/{aid}/balance-refunds | 申请余额退款 | 预充值服务服务 |
| 预充值用户/飞得高 | GET | /accounts/{aid}/balance-refunds | 获取余额退款列表 | 预充值服务服务 |
| 预充值用户/飞得高 | GET | /accounts/{aid}/balance-refunds/{bid} | 查看余额退款详情 | 预充值服务服务 |
| 飞得高/三方支付系统 | POST | /accounts/{aid}/balance-refunds/{bid}/confirmation | 确认余额退款 | 预充值服务服务 |
| 预充值用户/飞得高 | POST | /accounts/{aid}/ticket-refunds | 申请退票退款 | 预充值服务服务 |
| 预充值用户/飞得高 | GET | /accounts/{aid}/ticket-refunds | 获取退票退款列表 | 预充值服务服务 |
| 预充值用户/飞得高 | GET | /accounts/{aid}/ticket-refunds/{tid} | 查看退票退款详情 | 预充值服务服务 |
| 飞得高/三方支付系统 | POST | /accounts/{aid}/ticket-refunds/{tid}/confirmation | 确认退票退款 | 预充值服务服务 |
| 飞得高 | POST | /accounts/{aid}/payments | 请求支付购票费用 | 预充值服务服务 |
| 预充值用户/飞得高 | GET | /accounts/{aid}/payments | 获取购票费用支付列表 | 预充值服务服务 |
| 预充值用户/飞得高 | GET | /accounts/{aid}/payments/{pid} | 查看购票费用支付详情 | 预充值服务服务 |
| 预充值用户/飞得高 | POST | /accounts/{aid}/payments/{pid}/confirmation | 确认支付购票费用 | 预充值服务服务 |
| 预充值用户/飞得高 | POST | /accounts/{aid}/invoices | 申请发票开具 | 预充值服务服务 |
| 预充值用户/飞得高 | GET | /accounts/{aid}/invoices | 获取发票开具列表 | 预充值服务服务 |
| 预充值用户/飞得高 | GET | /accounts/{aid}/invoices/{iid} | 查看发票开具详情 | 预充值服务服务 |
| 飞得高/发票代开系统 | POST | /accounts/{aid}/invoices/{iid}/confirmation | 确认发票开具 | 预充值服务服务 |
| 预充值用户/飞得高 | POST | /accounts/{aid}/bills | 申请发送消费明细 | 预充值服务服务 |
| 预充值用户/飞得高 | GET | /accounts/{aid}/bills | 获取发送消费明细列表 | 预充值服务服务 |
| 预充值用户/飞得高 | GET | /accounts/{aid}/bills/{bid} | 查看发送消费明细详情 | 预充值服务服务 |
| 飞得高 | POST | /accounts/{aid}/bills/{bid}/confirmation | 确认发送消费明细 | 预充值服务服务 |



## 业务能力表 - 机票订单上下文
| Role | Method | URI | 业务能力 | 业务能力服务 |
| --- | --- | --- | --- | --- |
| 购票人/售票商 | POST | /orders | 创建机票订单 | 机票订单服务 |
| 售票商 | GET | /orders | 获取机票订单列表 | 机票订单服务 |
| 购票人/售票商 | GET | /orders/{oid} | 查看机票订单详情 | 机票订单服务 |
| 售票商 | POST | /orders/{oid}/confirmation | 确认机票订单 | 机票订单服务 |
| 购票人/售票商 | POST | /orders/{oid}/ticket | 申请出票 | 机票订单服务 |
| 购票人/售票商 | GET | /orders/{oid}/ticket | 查看出票详情 | 机票订单服务 |
| 售票商 | POST | /orders/{oid}/ticket/confirmation | 确认出票 | 机票订单服务 |
| 购票人/售票商 | POST | /orders/{oid}/baggage-weight | 申请购买行李托运重量 | 机票订单服务 |
| 购票人/售票商 | GET | /orders/{oid}/baggage-weight | 查看行李托运重量购买详情 | 机票订单服务 |
| 售票商 | POST | /orders/{oid}/baggage-weight/confirmation | 确认行李托运重量购买 | 机票订单服务 |
| 购票人/售票商 | POST | /orders/{oid}/refund | 购买退票退款 | 机票订单服务 |
| 购票人/售票商 | GET | /orders/{oid}/refund | 查看退票退款详情 | 机票订单服务 |
| 售票商/三方支付系统 | POST | /orders/{oid}/refund/confirmation | 确认退票退款 | 机票订单服务 |
| 购票人/售票商 | POST | /orders/{oid}/insurance | 申请购买保险 | 机票订单服务 |
| 购票人/售票商 | GET | /orders/{oid}/insurance | 查看保险单详情 | 机票订单服务 |
| 售票商/三方保险系统 | POST | /orders/{oid}/insurance/confirmation | 确认购买保险 | 机票订单服务 |
| 购票人/售票商 | POST | /orders/{oid}/check-in | 申请值机 | 机票订单服务 |
| 购票人/售票商 | GET | /orders/{oid}/check-in | 查看值机详情 | 机票订单服务 |
| 售票商 | POST | /orders/{oid}/check-in/confirmation | 确认值机 | 机票订单服务 |
| 购票人/售票商 | POST | /orders/{oid}/invoice | 申请开具发票 | 机票订单服务 |
| 购票人/售票商 | GET | /orders/{oid}/invoice | 查看开具发票详情 | 机票订单服务 |
| 售票商/发票代开系统 | POST | /orders/{oid}/invoice/confirmation | 确认开具发票 | 机票订单服务 |
| 购票人/售票商 | POST | /orders/{oid}/changing | 申请改签 | 机票订单服务 |
| 购票人/售票商 | GET | /orders/{oid}/changing | 查看改签详情 | 机票订单服务 |
| 售票商 | POST | /orders/{oid}/changing/confirmation | 确认改签 | 机票订单服务 |
| 售票商 | POST | /orders/{oid}/payment | 申请订单支付 | 机票订单服务 |
| 购票人/售票商 | GET | /orders/{oid}/payment | 查看订单支付详情 | 机票订单服务 |
| 购票人/三方支付系统 | POST | /orders/{oid}/payment/confirmation | 确认支付订单 | 机票订单服务 |



