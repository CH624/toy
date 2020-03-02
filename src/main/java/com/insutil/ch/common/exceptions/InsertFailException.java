package com.insutil.ch.common.exceptions;

public class InsertFailException extends Exception {

    private static final long serialVersionUID = 1L;

    public InsertFailException() {
        super("등록에 실패했습니다. 관리자 문의 바랍니다.");
    }

    public InsertFailException(final String msg) {
        super(msg);
    }

    public InsertFailException(final String msg, Throwable t) {
        super(msg, t);
    }
}

