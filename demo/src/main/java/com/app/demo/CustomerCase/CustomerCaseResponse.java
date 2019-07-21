package com.app.demo.CustomerCase;

public class CustomerCaseResponse {
    private Long id;
    private CaseState state;

    public CustomerCaseResponse(Long id, CaseState state)
    {
        this.id = id;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CaseState getState() {
        return state;
    }

    public void setState(CaseState state) {
        this.state = state;
    }
}
