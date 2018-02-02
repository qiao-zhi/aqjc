<?xml version="1.0" encoding="UTF-8"?>
<Form xmlVersion="20120203" releaseVersion="7.0.0">
<TableDataMap>
<TableData name="ds1" class="com.fr.data.impl.DBTableData">
<Parameters>
<Parameter>
<Attributes name="suppid" isAutoInc="false"/>
<O t="I">
<![CDATA[1]]></O>
</Parameter>
</Parameters>
<Attributes maxMemRowCount="-1"/>
<Connection class="com.fr.data.impl.NameDatabaseConnection">
<DatabaseName>
<![CDATA[FRDemo]]></DatabaseName>
</Connection>
<Query>
<![CDATA[SELECT * FROM [Supp_appl]A where supp_id=${suppid}]]></Query>
</TableData>
</TableDataMap>
<DesignAttr width="553" height="488"/>
<Layout class="com.fr.form.ui.container.WAbsoluteLayout">
<Listener event="afterinit">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters/>
<Content>
<![CDATA[var aa = this.options.form.getWidgetByName("suggest_result").getValue();
var bb = this.options.form.getWidgetByName("button0");
var cc = this.options.form.getWidgetByName("button1");
bb.setVisible(false);
cc.setVisible(false);
if(aa == "处理意见不通过")
{  
  cc.setVisible(true);
}
else
{
  bb.setVisible(true);
}]]></Content>
</JavaScript>
</Listener>
<WidgetName name="form"/>
<WidgetAttr/>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label0"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<FRFont name="SimSun" style="0" size="144"/>
<widgetValue>
<O>
<![CDATA[申请单]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="299" y="22" width="299" height="57"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.container.WAbsoluteLayout">
<WidgetName name="absolute0"/>
<WidgetAttr/>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label1"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<FRFont name="黑体" style="0" size="72"/>
<widgetValue>
<O>
<![CDATA[申请人：]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="7" y="11" width="80" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label2"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<widgetValue>
<databinding>
<![CDATA[{Name:ds1,Key:Supp_person}]]></databinding>
</widgetValue>
</InnerWidget>
<BoundsAttr x="93" y="11" width="120" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label3"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<FRFont name="黑体" style="0" size="72"/>
<widgetValue>
<O>
<![CDATA[申请时间：]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="226" y="12" width="80" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label4"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<widgetValue>
<databinding>
<![CDATA[{Name:ds1,Key:Supp_time}]]></databinding>
</widgetValue>
</InnerWidget>
<BoundsAttr x="314" y="12" width="87" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label5"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<FRFont name="黑体" style="0" size="72"/>
<widgetValue>
<O>
<![CDATA[所在单位：]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="7" y="45" width="80" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label6"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<widgetValue>
<databinding>
<![CDATA[{Name:ds1,Key:Supp_dept}]]></databinding>
</widgetValue>
</InnerWidget>
<BoundsAttr x="93" y="45" width="119" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label7"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<FRFont name="黑体" style="0" size="72"/>
<widgetValue>
<O>
<![CDATA[申请项目：]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="8" y="75" width="80" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label8"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<widgetValue>
<databinding>
<![CDATA[{Name:ds1,Key:Supp_item}]]></databinding>
</widgetValue>
</InnerWidget>
<BoundsAttr x="96" y="74" width="284" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label9"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<FRFont name="黑体" style="0" size="72"/>
<widgetValue>
<O>
<![CDATA[申请理由：]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="9" y="108" width="80" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label10"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<widgetValue>
<databinding>
<![CDATA[{Name:ds1,Key:Supp_reason}]]></databinding>
</widgetValue>
</InnerWidget>
<BoundsAttr x="98" y="109" width="285" height="21"/>
</Widget>
<Border style="1" corner="true"/>
<LCAttr vgap="0" hgap="0"/>
</InnerWidget>
<BoundsAttr x="219" y="79" width="459" height="148"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label11"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<FRFont name="SimSun" style="0" size="144"/>
<widgetValue>
<O>
<![CDATA[处理意见]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="299" y="257" width="299" height="66"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.container.WAbsoluteLayout">
<WidgetName name="absolute1"/>
<WidgetAttr/>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label12"/>
<WidgetAttr/>
<LabelAttr textalign="4" autoline="true"/>
<FRFont name="黑体" style="0" size="72"/>
<widgetValue>
<O>
<![CDATA[支持人员：]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="87" y="8" width="80" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label12_copy_copy"/>
<WidgetAttr/>
<LabelAttr textalign="4" autoline="true"/>
<FRFont name="黑体" style="0" size="72"/>
<widgetValue>
<O>
<![CDATA[支持时间：]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="87" y="43" width="80" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.TextEditor">
<WidgetName name="supp_man"/>
<WidgetAttr/>
<TextAttr/>
<widgetValue>
<databinding>
<![CDATA[{Name:ds1,Key:Supp_man}]]></databinding>
</widgetValue>
</InnerWidget>
<BoundsAttr x="179" y="7" width="200" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.DateEditor">
<Listener event="afteredit">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters/>
<Content>
<![CDATA[var time = this.options.form.getWidgetByName("label4").getValue();
var value = this.getValue();
if(value < time){
   alert("支持时间必须大于申请时间");
}]]></Content>
</JavaScript>
</Listener>
<WidgetName name="supp_time"/>
<WidgetAttr/>
<DateAttr/>
<widgetValue>
<databinding>
<![CDATA[{Name:ds1,Key:Supp_Date}]]></databinding>
</widgetValue>
</InnerWidget>
<BoundsAttr x="180" y="42" width="199" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.Commit2DBJavaScript">
<Parameters/>
<Attributes dsName="FRDemo"/>
<DMLConfig class="com.fr.base.write.config.IntelliDMLConfig">
<Table schema="" name="Supp_appl"/>
<ColumnConfig name="Supp_id" isKey="true">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=$sid]]></Attributes>
</O>
</ColumnConfig>
<ColumnConfig name="Supp_mode" isKey="false">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=$supp_mode]]></Attributes>
</O>
</ColumnConfig>
<ColumnConfig name="Supp_Date" isKey="false">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=$supp_time]]></Attributes>
</O>
</ColumnConfig>
<ColumnConfig name="Supp_man" isKey="false">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=$supp_man]]></Attributes>
</O>
</ColumnConfig>
</DMLConfig>
<JavaScript class="com.fr.base.js.ProcessJSImpl">
<Parameters>
<Parameter>
<Attributes name="suppid" isAutoInc="false"/>
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=$Supp_id]]></Attributes>
</O>
</Parameter>
</Parameters>
<Content>
<![CDATA[已处理]]></Content>
</JavaScript>
</JavaScript>
</Listener>
<WidgetName name="button0"/>
<WidgetAttr/>
<Text>
<![CDATA[提交]]></Text>
</InnerWidget>
<BoundsAttr x="182" y="112" width="95" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.ComboBox">
<WidgetName name="supp_mode"/>
<WidgetAttr/>
<Dictionary class="com.fr.data.impl.CustomDictionary">
<CustomDictAttr>
<Dict key="远程" value="远程"/>
<Dict key="现场" value="现场"/>
</CustomDictAttr>
</Dictionary>
<widgetValue>
<databinding>
<![CDATA[{Name:ds1,Key:Supp_mode}]]></databinding>
</widgetValue>
</InnerWidget>
<BoundsAttr x="180" y="81" width="198" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label13"/>
<WidgetAttr/>
<LabelAttr textalign="4" autoline="true"/>
<FRFont name="黑体" style="0" size="72"/>
<widgetValue>
<O>
<![CDATA[支持方式：]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="89" y="79" width="80" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.Commit2DBJavaScript">
<Parameters/>
<Attributes dsName="FRDemo"/>
<DMLConfig class="com.fr.base.write.config.IntelliDMLConfig">
<Table schema="" name="Supp_appl"/>
<ColumnConfig name="Supp_id" isKey="true">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=$sid]]></Attributes>
</O>
</ColumnConfig>
<ColumnConfig name="Supp_mode" isKey="false">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=$supp_mode]]></Attributes>
</O>
</ColumnConfig>
<ColumnConfig name="Supp_Date" isKey="false">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=$supp_time]]></Attributes>
</O>
</ColumnConfig>
<ColumnConfig name="Supp_man" isKey="false">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=$supp_man]]></Attributes>
</O>
</ColumnConfig>
</DMLConfig>
<JavaScript class="com.fr.base.js.ProcessJSImpl">
<Parameters>
<Parameter>
<Attributes name="suppid" isAutoInc="false"/>
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=$Supp_id]]></Attributes>
</O>
</Parameter>
<Parameter>
<Attributes name="aa" isAutoInc="true"/>
<O>
<![CDATA[]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[已处理]]></Content>
</JavaScript>
</JavaScript>
</Listener>
<WidgetName name="button1"/>
<WidgetAttr invisible="true"/>
<Text>
<![CDATA[重新提交]]></Text>
</InnerWidget>
<BoundsAttr x="176" y="108" width="92" height="21"/>
</Widget>
<Border style="1" corner="true"/>
<LCAttr vgap="0" hgap="0"/>
</InnerWidget>
<BoundsAttr x="219" y="344" width="459" height="144"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="suggest_result"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<FRFont name="SimSun" style="0" size="72" foreground="-65536"/>
<widgetValue>
<databinding>
<![CDATA[{Name:ds1,Key:Suggest_result}]]></databinding>
</widgetValue>
</InnerWidget>
<BoundsAttr x="496" y="280" width="119" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="sid"/>
<WidgetAttr invisible="true"/>
<LabelAttr textalign="0" autoline="true"/>
<widgetValue>
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=$suppid]]></Attributes>
</O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="33" y="22" width="80" height="21"/>
</Widget>
<LCAttr vgap="0" hgap="0"/>
</Layout>
</Form>
