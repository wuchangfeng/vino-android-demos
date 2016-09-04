package com.wu.allen.toucheventdemo;

/**
 * Created by allen on 2016/9/3.
 */

public class test {

    /**
     * byyd : 0.24
     * dlye : 14.21
     * dssj : 2016-07-14 13:50
     * qsh : 190406
     * syts : >100
     * xjye : 8.81
     * zxds : 1746.4
     */

    private DataBean data;
    /**
     * data : {"byyd":"0.24","dlye":"14.21","dssj":"2016-07-14 13:50","qsh":"190406","syts":">100","xjye":"8.81","zxds":"1746.4"}
     * message : 查询成功
     * qsh : 190406
     * status : 1
     */

    private String message;
    private String qsh;
    private int status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getQsh() {
        return qsh;
    }

    public void setQsh(String qsh) {
        this.qsh = qsh;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class DataBean {
        private String byyd;
        private String dlye;
        private String dssj;
        private String qsh;
        private String syts;
        private String xjye;
        private String zxds;

        public String getByyd() {
            return byyd;
        }

        public void setByyd(String byyd) {
            this.byyd = byyd;
        }

        public String getDlye() {
            return dlye;
        }

        public void setDlye(String dlye) {
            this.dlye = dlye;
        }

        public String getDssj() {
            return dssj;
        }

        public void setDssj(String dssj) {
            this.dssj = dssj;
        }

        public String getQsh() {
            return qsh;
        }

        public void setQsh(String qsh) {
            this.qsh = qsh;
        }

        public String getSyts() {
            return syts;
        }

        public void setSyts(String syts) {
            this.syts = syts;
        }

        public String getXjye() {
            return xjye;
        }

        public void setXjye(String xjye) {
            this.xjye = xjye;
        }

        public String getZxds() {
            return zxds;
        }

        public void setZxds(String zxds) {
            this.zxds = zxds;
        }
    }
}
