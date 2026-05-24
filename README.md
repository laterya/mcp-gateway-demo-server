# MCP Gateway Demo Server

MCP Gateway 的演示服务，提供员工管理相关的 Swagger 测试接口，用于验证网关的 OpenAPI 解析和 HTTP 路由功能。

## 快速开始

```bash
mvn spring-boot:run
```

启动后访问：
- Swagger UI：`http://localhost:8701/swagger-ui/index.html`
- OpenAPI JSON：`http://localhost:8701/v3/api-docs`

## 接口

| 方法 | 路径 | 说明 |
|------|------|------|
| POST | `/api/v1/employee/query` | 查询员工列表 |
| GET | `/api/v1/employee/{id}` | 获取员工详情 |
| GET | `/api/v1/department/list` | 部门列表 |

## 在 MCP Gateway 中使用

1. 启动 demo-server（端口 8701）
2. 在网关管理后台导入 `http://localhost:8701/v3/api-docs` 的 OpenAPI JSON
3. 网关自动解析生成协议配置和字段映射
