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
<Layout class="com.fr.form.ui.container.WAbsoluteLayout">
<WidgetName name="form"/>
<WidgetAttr/>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label0_copy"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<FRFont name="SimSun" style="0" size="144"/>
<widgetValue>
<O>
<![CDATA[批复意见]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="298" y="42" width="299" height="57"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.container.WAbsoluteLayout">
<WidgetName name="absolute0_copy"/>
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
<BoundsAttr x="314" y="12" width="126" height="21"/>
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
<BoundsAttr x="97" y="110" width="285" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label11"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<FRFont name="黑体" style="0" size="72"/>
<widgetValue>
<O>
<![CDATA[支持时间：]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="226" y="141" width="80" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label12"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<FRFont name="黑体" style="0" size="72"/>
<widgetValue>
<O>
<![CDATA[支持方式：]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="9" y="176" width="80" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label13"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<widgetValue>
<databinding>
<![CDATA[{Name:ds1,Key:Supp_man}]]></databinding>
</widgetValue>
</InnerWidget>
<BoundsAttr x="98" y="141" width="113" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label14"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<widgetValue>
<databinding>
<![CDATA[{Name:ds1,Key:Supp_Date}]]></databinding>
</widgetValue>
</InnerWidget>
<BoundsAttr x="315" y="141" width="121" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label15"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<widgetValue>
<databinding>
<![CDATA[{Name:ds1,Key:Supp_mode}]]></databinding>
</widgetValue>
</InnerWidget>
<BoundsAttr x="100" y="176" width="111" height="21"/>
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
<ColumnConfig name="Suggest_result" isKey="false">
<O>
<![CDATA[同意]]></O>
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
<![CDATA[同意]]></Content>
</JavaScript>
</JavaScript>
</Listener>
<WidgetName name="button0"/>
<WidgetAttr/>
<Text>
<![CDATA[同意]]></Text>
</InnerWidget>
<BoundsAttr x="71" y="211" width="80" height="21"/>
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
<ColumnConfig name="Suggest_result" isKey="false">
<O>
<![CDATA[(驳回)]]></O>
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
<![CDATA[驳回]]></Content>
</JavaScript>
</JavaScript>
</Listener>
<WidgetName name="button1"/>
<WidgetAttr/>
<Text>
<![CDATA[申请单不通过]]></Text>
</InnerWidget>
<BoundsAttr x="189" y="212" width="80" height="21"/>
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
<ColumnConfig name="Suggest_result" isKey="false">
<O>
<![CDATA[(审批不通过)]]></O>
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
<![CDATA[处理意见不通过]]></Content>
</JavaScript>
</JavaScript>
</Listener>
<WidgetName name="button2"/>
<WidgetAttr/>
<Text>
<![CDATA[处理意见不通过]]></Text>
</InnerWidget>
<BoundsAttr x="297" y="211" width="89" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label0"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<FRFont name="黑体" style="0" size="72"/>
<widgetValue>
<O>
<![CDATA[支持人员：]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="8" y="143" width="80" height="21"/>
</Widget>
<Border style="1" corner="true"/>
<LCAttr vgap="0" hgap="0"/>
</InnerWidget>
<BoundsAttr x="218" y="99" width="459" height="240"/>
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
<BoundsAttr x="10" y="51" width="80" height="21"/>
</Widget>
<LCAttr vgap="0" hgap="0"/>
</Layout>
</Form>
