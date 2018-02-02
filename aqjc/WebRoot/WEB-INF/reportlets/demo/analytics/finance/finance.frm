<?xml version="1.0" encoding="UTF-8"?>
<Form xmlVersion="20120203" releaseVersion="7.0.0">
<TableDataMap>
<TableData name="ds1" class="com.fr.data.impl.DBTableData">
<Parameters/>
<Attributes maxMemRowCount="-1"/>
<Connection class="com.fr.data.impl.NameDatabaseConnection">
<DatabaseName>
<![CDATA[FRDemo]]></DatabaseName>
</Connection>
<Query>
<![CDATA[select 年份 from 收入成本
group by 年份]]></Query>
</TableData>
</TableDataMap>
<DesignAttr width="1000" height="1400"/>
<Layout class="com.fr.form.ui.container.WAbsoluteLayout">
<WidgetName name="form"/>
<WidgetAttr/>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label0"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<FRFont name="SimSun" style="1" size="64" foreground="-6908266"/>
<widgetValue>
<O>
<![CDATA[主题分析->财务主题->财务主题分析主页]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="2" y="1" width="263" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.IframeEditor">
<WidgetName name="finance1"/>
<WidgetAttr/>
<Iframe src="${servletURL}?reportlet=demo/analytics/finance/finance1.cpt&amp;__showtoolbar__=false" overflowx="true" overflowy="true"/>
<Parameters/>
</InnerWidget>
<BoundsAttr x="0" y="60" width="260" height="209"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.IframeEditor">
<WidgetName name="finance2"/>
<WidgetAttr/>
<Iframe src="${servletURL}?reportlet=demo/analytics/finance/finance3.cpt&amp;__showtoolbar__=false" overflowx="true" overflowy="true"/>
<Parameters/>
</InnerWidget>
<BoundsAttr x="-2" y="270" width="260" height="530"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.IframeEditor">
<WidgetName name="finance3"/>
<WidgetAttr/>
<Iframe src="${servletURL}?reportlet=demo/analytics/finance/finance2.cpt&amp;__showtoolbar__=false" overflowx="true" overflowy="true"/>
<Parameters/>
</InnerWidget>
<BoundsAttr x="260" y="60" width="718" height="209"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.IframeEditor">
<WidgetName name="finance4"/>
<WidgetAttr/>
<Iframe src="${servletURL}?reportlet=demo/analytics/finance/finance4.cpt&amp;__showtoolbar__=false" overflowx="true" overflowy="true"/>
<Parameters/>
</InnerWidget>
<BoundsAttr x="260" y="270" width="720" height="530"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.ComboBox">
<WidgetName name="year"/>
<WidgetAttr/>
<Dictionary class="com.fr.data.impl.CustomDictionary">
<CustomDictAttr>
<Dict key="2009" value="2009"/>
<Dict key="2010" value="2010"/>
<Dict key="2011" value="2011"/>
</CustomDictAttr>
</Dictionary>
<widgetValue>
<O>
<![CDATA[2009]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="742" y="30" width="93" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters/>
<Content>
<![CDATA[var year=this.options.form.getWidgetByName("year").getText();
var s=function(wid,para){
var src="";
var pairs = wid.getValue().split("&");
for(var i = 0; i < pairs.length; i++) {
var pos = pairs[i]A.indexOf('=');        
if (pos != -1){               
var argname = pairs[i]A.substring(0,pos); 
if(argname=="year"){
continue;
}     
}
src+=pairs[i]A+"&";               
}
src+="year="+para.year;
wid.setValue(src);
}
for(var i=1;i<4;i++){
s(this.options.form.getWidgetByName("finance"+i),{"year":year})
}]]></Content>
</JavaScript>
</Listener>
<WidgetName name="formSubmit0"/>
<WidgetAttr/>
<Text>
<![CDATA[查询]]></Text>
<Hotkeys>
<![CDATA[enter]]></Hotkeys>
</InnerWidget>
<BoundsAttr x="870" y="30" width="80" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label0"/>
<WidgetAttr/>
<LabelAttr textalign="4" autoline="true"/>
<widgetValue>
<O>
<![CDATA[请选择年份：]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="659" y="30" width="80" height="21"/>
</Widget>
<LCAttr vgap="0" hgap="0"/>
</Layout>
</Form>
