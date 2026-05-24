package cn.laterya.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Department", description = "部门信息")
public class Department {

    @Schema(description = "部门ID", example = "1")
    private Long id;

    @Schema(description = "部门名称", example = "技术部")
    private String name;

    @Schema(description = "部门负责人", example = "王总监")
    private String manager;

    @Schema(description = "员工人数", example = "35")
    private Integer employeeCount;
}
