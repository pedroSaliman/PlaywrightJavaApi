package org;

import java.util.HashMap;
import java.util.Map;

public class PayLoad {

    public static Map<String,String> map(){

        Map<String,String> body=new HashMap<>();
        body.put("name","mohamed");
        body.put("job","Tester");
        return body;
    }
    public static Map<String,String> mapput(){

        Map<String,String> body=new HashMap<>();
        body.put("name","walled");
        body.put("job","developer");
        return body;
    }
    public static Map<String,String> Register(){

        Map<String,String> body=new HashMap<>();
        body.put("email","eve.holt@reqres.in");
        body.put("password","pistol");
        return body;
    }
    public static Map<String,String> Login(){

        Map<String,String> body=new HashMap<>();
        body.put("email","eve.holt@reqres.in");
        body.put("password","cityslicka");
        return body;
    }
}
