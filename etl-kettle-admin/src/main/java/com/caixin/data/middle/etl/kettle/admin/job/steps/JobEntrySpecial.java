/**
 * Copyright (C), 2019-2020, **有限公司
 * FileName: JobEntrySpecial
 * Author:   zhuzj29042
 * Date:     2020/2/14 17:04::32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.caixin.data.middle.etl.kettle.admin.job.steps;

import com.caixin.data.middle.etl.kettle.ext.core.PropsUI;
import com.caixin.data.middle.etl.kettle.ext.job.step.AbstractJobEntry;
import com.mxgraph.model.mxCell;
import com.mxgraph.util.mxUtils;
import org.pentaho.di.core.Const;
import org.pentaho.di.core.database.DatabaseMeta;
import org.pentaho.di.job.entry.JobEntryInterface;
import org.pentaho.metastore.api.IMetaStore;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 *
 *
 * @author zhuzhongji
 * @create 2020/2/14 17:04:32
 * @since 1.0.0
 */
@Component("SPECIAL")
@Scope("prototype")
public class JobEntrySpecial extends AbstractJobEntry {

    @Override
    public void decode(JobEntryInterface jobEntry, mxCell cell, List<DatabaseMeta> databases, IMetaStore metaStore) throws Exception {
        org.pentaho.di.job.entries.special.JobEntrySpecial jobEntrySpecial = (org.pentaho.di.job.entries.special.JobEntrySpecial) jobEntry;

        jobEntrySpecial.setStart("Y".equalsIgnoreCase(cell.getAttribute("start")));
        jobEntrySpecial.setDummy("Y".equalsIgnoreCase(cell.getAttribute("dummy")));
        jobEntrySpecial.setRepeat("Y".equalsIgnoreCase(cell.getAttribute("repeat")));
        jobEntrySpecial.setSchedulerType(Const.toInt( cell.getAttribute( "schedulerType" ),  org.pentaho.di.job.entries.special.JobEntrySpecial.NOSCHEDULING ));
        jobEntrySpecial.setIntervalSeconds( Const.toInt( cell.getAttribute( "intervalSeconds" ), 0 ) );
        jobEntrySpecial.setIntervalMinutes( Const.toInt( cell.getAttribute( "intervalMinutes" ), 0 ) );
        jobEntrySpecial.setHour( Const.toInt( cell.getAttribute( "hour" ), 0 ) );
        jobEntrySpecial.setMinutes( Const.toInt( cell.getAttribute( "minutes" ), 0 ) );
        jobEntrySpecial.setWeekDay( Const.toInt( cell.getAttribute( "weekDay" ), 0 ) );
        jobEntrySpecial.setDayOfMonth( Const.toInt( cell.getAttribute( "dayOfMonth" ), 0 ) );
    }

    @Override
    public Element encode(JobEntryInterface jobEntry) throws Exception {
        org.pentaho.di.job.entries.special.JobEntrySpecial jobEntrySpecial = (org.pentaho.di.job.entries.special.JobEntrySpecial) jobEntry;
        Document doc = mxUtils.createDocument();
        Element e = doc.createElement(PropsUI.JOB_JOBENTRY_NAME);

        e.setAttribute("start", jobEntrySpecial.isStart() ? "Y" : "N");
        e.setAttribute("dummy", jobEntrySpecial.isDummy() ? "Y" : "N");
        e.setAttribute("repeat", jobEntrySpecial.isRepeat() ? "Y" : "N");
        e.setAttribute("schedulerType", jobEntrySpecial.getSchedulerType() + "");
        e.setAttribute("intervalSeconds", jobEntrySpecial.getIntervalSeconds() + "");
        e.setAttribute("intervalMinutes", jobEntrySpecial.getIntervalMinutes() + "");
        e.setAttribute("hour", jobEntrySpecial.getHour() + "");
        e.setAttribute("minutes", jobEntrySpecial.getMinutes() + "");
        e.setAttribute("weekDay", jobEntrySpecial.getWeekDay() + "");
        e.setAttribute("DayOfMonth", jobEntrySpecial.getDayOfMonth() + "");
        e.setAttribute("schedulerType", jobEntrySpecial.getSchedulerType()+"");

        return e;
    }


}
