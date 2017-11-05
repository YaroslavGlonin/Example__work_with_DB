package db;

import java.util.Comparator;

class Data {
	String PZN;
	String UER;
	String RGN;
	String IND;
	String TNP;
	String NNP;
	String ADR;
	String RKC;
	String NAMEP;
	String NEWNUM;
	String NEWKS;
	String TELEF;
	String REGN;
	String OKPO;
	String DATEDEL;
	String KSNP;
	String R_CLOSE;
	String DATE_IN;

    public Data(String PZN,String UER,String RGN,String IND,String TNP,String NNP,String ADR,String RKC,String NAMEP,
    		String NEWNUM,String NEWKS,String TELEF,String REGN,String OKPO,String DATEDEL,String KSNP,String R_CLOSE,
    		String DATE_IN) {
        super();
        this.PZN = PZN;
        this.UER = UER;
        this.RGN = RGN;
        this.IND = IND;
        this.TNP = TNP;
        this.NNP = NNP;
        this.ADR= ADR;
        this.RKC = RKC;
        this.NAMEP = NAMEP;
        this.NEWNUM = NEWNUM;
        this.NEWKS = NEWKS;
        this.TELEF = TELEF;
        this.REGN = REGN;
        this.OKPO = OKPO;
        this.DATEDEL = DATEDEL;
        this.KSNP = KSNP;
        this.R_CLOSE = R_CLOSE;
        this.DATE_IN = DATE_IN;
        
    }

    public String getPZN() {
        return PZN;
    }

    public void setPZN(String PZN) {
        this.PZN = PZN;
    }
    public String getUER() {
        return UER;
    }

    public void setUER(String UER) {
        this.UER = UER;
    }
    public String getRGN() {
        return RGN;
    }

    public void setRGN(String RGN) {
        this.RGN = RGN;
    }
    public String getIND() {
        return IND;
    }

    public void setIND(String IND) {
        this.IND = IND;
    }
    
    public String getTNP() {
        return TNP;
    }

    public void setTNP(String TNP) {
        this.TNP = TNP;
    }
    public String getNNP() {
        return NNP;
    }

    public void setNNP(String NNP) {
        this.NNP = NNP;
    }
    public String getADR() {
        return ADR;
    }

    public void setADR(String ADR) {
        this.ADR = ADR;
    }
    public String getRKC() {
        return RKC;
    }

    public void setRKC(String RKC) {
        this.RKC = RKC;
    }
    public String getTELEF() {
        return TELEF;
    }

    public void setTELEF(String TELEF) {
        this.TELEF = TELEF;
    }
    
    public String getNEWNUM() {
        return NEWNUM;
    }

    public void setNEWNUM(String NEWNUM) {
        this.NEWNUM = NEWNUM;
    }
    public String getNEWKS() {
        return NEWKS;
    }

    public void setNEWKS(String NEWKS) {
        this.NEWKS = NEWKS;
    }
    public String getNAMEP() {
        return NAMEP;
    }

    public void setNAMEP(String NAMEP) {
        this.NAMEP = NAMEP;
    }
    public String getREGN() {
        return REGN;
    }

    public void setREGN(String REGN) {
        this.REGN = REGN;
    }
    public String getOKPO() {
        return OKPO;
    }

    public void setOKPO(String OKPO) {
        this.OKPO = OKPO;
    }
    public String getDATEDEL() {
        return DATEDEL;
    }

    public void setDATEDEL(String DATEDEL) {
        this.DATEDEL = DATEDEL;
    }
    public String getKSNP() {
        return NAMEP;
    }

    public void setKSNP(String KSNP) {
        this.KSNP = KSNP;
    }
    public String getR_CLOSE() {
        return R_CLOSE;
    }

    public void setR_CLOSE(String R_CLOSE) {
        this.R_CLOSE = R_CLOSE;
    }
    public String getDATE_IN() {
        return DATE_IN;
    }

    public void setDATE_IN(String DATE_IN) {
        this.DATE_IN = DATE_IN;
    }
}
