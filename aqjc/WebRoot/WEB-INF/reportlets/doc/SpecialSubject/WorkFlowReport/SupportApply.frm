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
<![CDATA[SELECT * FROM [Supp_appl]A]]></Query>
</TableData>
</TableDataMap>
<Layout class="com.fr.form.ui.container.WAbsoluteLayout">
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
<![CDATA[技术支持申请单]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="300" y="45" width="376" height="54"/>
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
<BoundsAttr x="13" y="41" width="80" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.TextEditor">
<WidgetName name="supp_person"/>
<WidgetAttr/>
<TextAttr/>
</InnerWidget>
<BoundsAttr x="95" y="41" width="132" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label2"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<FRFont name="黑体" style="0" size="72"/>
<widgetValue>
<O>
<![CDATA[申请时间：]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="300" y="6" width="72" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="supp_time"/>
<WidgetAttr/>
<LabelAttr textalign="2" autoline="true"/>
<widgetValue>
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=format(today(),"yyyy-MM-dd")]]></Attributes>
</O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="379" y="6" width="116" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label4"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<FRFont name="黑体" style="0" size="72"/>
<widgetValue>
<O>
<![CDATA[所在单位：]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="299" y="42" width="74" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.ComboBox">
<WidgetName name="supp_dept"/>
<WidgetAttr/>
<Dictionary class="com.fr.data.impl.DatabaseDictionary">
<FormulaDictAttr ki="1" vi="1"/>
<DBDictAttr tableName="单位" schemaName="" ki="1" vi="1"/>
<Connection class="com.fr.data.impl.NameDatabaseConnection">
<DatabaseName>
<![CDATA[FRDemo]]></DatabaseName>
</Connection>
</Dictionary>
<widgetValue/>
</InnerWidget>
<BoundsAttr x="377" y="41" width="140" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label5"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<FRFont name="黑体" style="0" size="72"/>
<widgetValue>
<O>
<![CDATA[申请项目：]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="12" y="76" width="81" height="24"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.TextArea">
<WidgetName name="supp_item"/>
<WidgetAttr/>
<TextAttr/>
</InnerWidget>
<BoundsAttr x="96" y="76" width="414" height="63"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.Label">
<WidgetName name="label6"/>
<WidgetAttr/>
<LabelAttr textalign="0" autoline="true"/>
<FRFont name="黑体" style="0" size="72"/>
<widgetValue>
<O>
<![CDATA[申请理由：]]></O>
</widgetValue>
</InnerWidget>
<BoundsAttr x="13" y="149" width="80" height="20"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.TextArea">
<WidgetName name="supp_reseaon"/>
<WidgetAttr/>
<TextAttr/>
</InnerWidget>
<BoundsAttr x="95" y="149" width="413" height="120"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.Commit2DBJavaScript">
<Parameters/>
<Attributes dsName="FRDemo"/>
<DMLConfig class="com.fr.base.write.config.InsertConfig">
<Table schema="" name="Supp_appl"/>
<ColumnConfig name="Supp_person" isKey="false">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=$supp_person]]></Attributes>
</O>
</ColumnConfig>
<ColumnConfig name="Supp_time" isKey="false">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=$supp_time]]></Attributes>
</O>
</ColumnConfig>
<ColumnConfig name="Supp_item" isKey="false">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=$supp_item]]></Attributes>
</O>
</ColumnConfig>
<ColumnConfig name="Supp_reason" isKey="false">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=$supp_reseaon]]></Attributes>
</O>
</ColumnConfig>
<ColumnConfig name="Supp_dept" isKey="false">
<O t="Formula" class="Formula">
<Attributes>
<![CDATA[=$supp_dept]]></Attributes>
</O>
</ColumnConfig>
<ColumnConfig name="Supp_id" isKey="true">
<O>
<![CDATA[]]></O>
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
<![CDATA[提交]]></Content>
</JavaScript>
</JavaScript>
</Listener>
<WidgetName name="button0"/>
<WidgetAttr/>
<Text>
<![CDATA[提交申请]]></Text>
</InnerWidget>
<BoundsAttr x="241" y="281" width="80" height="21"/>
</Widget>
<Border style="1" corner="true"/>
<LCAttr vgap="0" hgap="0"/>
</InnerWidget>
<BoundsAttr x="207" y="99" width="562" height="314"/>
</Widget>
<LCAttr vgap="0" hgap="0"/>
</Layout>
</Form>
