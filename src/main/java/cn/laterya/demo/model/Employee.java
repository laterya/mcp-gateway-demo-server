package cn.laterya.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Employee", description = "员工信息")
public class Employee {

    @Schema(description = "员工ID", example = "1")
    private Long id;

    @Schema(description = "员工姓名", example = "张三")
    private String name;

    @Schema(description = "部门", example = "技术部")
    private String department;

    @Schema(description = "职位", example = "高级工程师")
    private String position;

    @Schema(description = "月薪（元）", example = "25000")
    private Integer salary;

    @Schema(description = "所在城市", example = "北京")
    private String city;

    @Schema(description = "入职日期", example = "2022-03-15")
    private String hireDate;

    @Schema(description = "邮箱", example = "zhangsan@example.com")
    private String email;
}
