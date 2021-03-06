/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handlersOption;

import cern.jet.random.Normal;
import cern.jet.random.engine.RandomEngine;
import finproject_23.*;
import PairHandlers.CommonHandlerForPair;


/**
 *
 * @author Admin
 */
public class CommonHandler {
    protected SqlQueryClass sqlClass=null;
    protected String optionName="EUROPEAN";
    
    public Double Call(double S,double X, double r, double T,double a){
        Normal n = new Normal(0.0,1.0,RandomEngine.makeDefault());
        Double d1 = (Math.log(S/X)+(r+a*a/2)/T)/(a*Math.sqrt(T));
        Double d2 = d1-a*Math.sqrt(T);
        Double res = S*n.cdf(d1)-X*Math.pow(Math.E, -r*T)*n.cdf(d2);
        return res;
    }
    
    public Object[] Put(){
        return new Object[0];
    }    

    
//    public String getCurrencyPair() {
//        return this.pair.getCurrpair();
//    }

    public String getOptionName(){
        return this.optionName;
    }
    
    public void setOption(SqlQueryClass db) {
        this.sqlClass=db;
//        if(this.pair!=null)
//            pair.setDBConn(db);
    }
//    
//    public void setOption(CommonHandlerForPair pair){
////        this.pair=pair;
//        if(this.sqlClass!=null)
//            pair.setDBConn(sqlClass);
//    }
    
    public void setOption(CommonHandlerForPair pair,SqlQueryClass db){
//        this.pair=pair;
        this.sqlClass=db;        
    }
}
