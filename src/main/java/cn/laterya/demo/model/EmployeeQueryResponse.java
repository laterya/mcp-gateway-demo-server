package cn.laterya.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "EmployeeQueryResponse", description = "员工查询响应")
public class EmployeeQueryResponse {

    @Schema(description = "员工列表")
    private List<Employee> employees;

    @Schema(description = "总数", example = "5")
    private Integer total;
}
