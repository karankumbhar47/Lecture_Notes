package com.assembler;

import com.assembler.custom.Utils;
import com.assembler.custom.DataMap;

public class Code {
    public String dest(String destination){
        return Utils.toBinaryString(DataMap.destMap.get(destination),3);
    }

    public String comp(String computation){
        return Utils.toBinaryString(DataMap.compMap.get(computation),7);
    }

    public String jump(String jumpCondition){
        return Utils.toBinaryString(DataMap.jumpMap.get(jumpCondition),3);
    }
}
