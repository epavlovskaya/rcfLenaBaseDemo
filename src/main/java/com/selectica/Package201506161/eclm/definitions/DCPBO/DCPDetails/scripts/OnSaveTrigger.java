package com.selectica.Package201506161.eclm.definitions.DCPBO.DCPDetails.scripts;

import com.selectica.Package201506161.stubs.DCPDBA;
import com.selectica.Package201506161.stubs.DCPDetails;
import com.selectica.rcfscripts.AbstractDataWriteScript;

import java.util.Iterator;
import java.util.List;

/**
 * Created by vshilkin on 21.05.2015.
 */
public class OnSaveTrigger extends AbstractDataWriteScript<Boolean> {
    /*
            <![CDATA[
            var dbaList = thisBundle.getValue("ReqDCPDBA");
            var allKnownNames = '';
            var dbaIt = dbaList.iterator();
            while (dbaIt.hasNext()) {
                var dbaComp = dbaIt.next();
                var dbaName = dbaComp.get("dbaName");
                allKnownNames = allKnownNames + dbaName;
                if(dbaIt.hasNext()){
                    allKnownNames = allKnownNames + '|';
                }
            }
            var name = thisComponent.getBundleProxy().getParameterValueObjectFromAnyComponent("ReqDCPDetails", "name");
            if (name != '') {
                if (allKnownNames != '') {
                    allKnownNames = allKnownNames + '|' + name;
                } else {
                    allKnownNames = name;
                }
            }
            thisBundle.setValue("allKnownNames", allKnownNames);
          ]]>
     */

    @Override
    public Boolean process() throws Exception {
        DCPDetails details = getHelper().getCurrentComponentStub();

        String allKnownNames = "";
        List<DCPDBA> dbaList = getHelper().getNodesStubs("ReqDCPDBA");
        Iterator<DCPDBA> dCounterpartyDBAIterator = dbaList.iterator();
        while (dCounterpartyDBAIterator.hasNext()) {
            allKnownNames += dCounterpartyDBAIterator.next().getDbaName();
            if (dCounterpartyDBAIterator.hasNext()) {
                allKnownNames += "|";
            }
        }

        String name = details.getName();
        if (!name.isEmpty()) {
            if (!allKnownNames.isEmpty()) {
                allKnownNames = allKnownNames + '|' + name;
            } else {
                allKnownNames = name;
            }
        }

        details.setAllKnownNames(allKnownNames);

        return true;
    }
}


