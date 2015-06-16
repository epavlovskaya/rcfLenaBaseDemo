package com.selectica.Package201506161.eclm.definitions.shared.ContractInfoComponent.scripts;

import com.selectica.rcfscripts.AbstractDataWriteScript;

/**
 * Created by vshilkin on 21/01/2015.
 */
public class SetRequestorScript extends AbstractDataWriteScript<String> {
    /*
            <![CDATA[
            result = root.getValue("user").getUserWrapper().getUserIDStr();
            ]]>
     */
    @Override
    public String process() throws Exception {
        return getHelper().getRCFUserWrapper().getUserIDStr();
    }
}
