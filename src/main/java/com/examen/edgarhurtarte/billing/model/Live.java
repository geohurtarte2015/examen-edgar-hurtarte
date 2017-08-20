package com.examen.edgarhurtarte.billing.model;

public class Live {
	
	private final long id;
    private final String content;

    public Live(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
	

}
