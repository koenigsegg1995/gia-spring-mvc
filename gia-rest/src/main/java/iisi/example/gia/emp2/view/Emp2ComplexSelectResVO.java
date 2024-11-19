package iisi.example.gia.emp2.view;

import iisi.example.gia.emp2.dto.Emp2ComplexSelectRes;
import iisi.example.gia.emp2.dto.PageInfo;

import java.util.List;

// 供前端查詢顯示
public class Emp2ComplexSelectResVO {

    List<Emp2ComplexSelectRes> empSelectRes;
    PageInfo pageInfo;

    // Getters & Setters
    public List<Emp2ComplexSelectRes> getEmpSelectRes() {
        return empSelectRes;
    }

    public void setEmpSelectRes(List<Emp2ComplexSelectRes> empSelectRes) {
        this.empSelectRes = empSelectRes;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

}
