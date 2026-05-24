package cn.laterya.demo.model;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "EmployeeQueryRequest", description = "员工查询请求")
public class EmployeeQueryRequest {

    @JsonPropertyDescription("所在城市，如：北京、上海、深圳")
    @Schema(description = "所在城市", example = "北京")
    private String city;

    @JsonPropertyDescription("部门名称，如：技术部、产品部、市场部")
    @Schema(description = "部门名称", example = "技术部")
    private String departmentName;

    @JsonPropertyDescription("搜索关键词（匹配姓名或职位）")
    @Schema(description = "搜索关键词（匹配姓名或职位）", example = "工程师")
    private String keyword;
}
