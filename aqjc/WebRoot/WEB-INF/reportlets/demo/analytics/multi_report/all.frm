<?xml version="1.0" encoding="UTF-8"?>
<Form xmlVersion="20120203" releaseVersion="6.5.6">
<DesignAttr width="1200" height="1800"/>
<Layout class="com.fr.form.ui.container.WAbsoluteLayout">
<WidgetName name="form"/>
<WidgetAttr/>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters>
<Parameter>
<Attributes name="table"/>
<O>
<![CDATA[1]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[this.options.form.getWidgetByName("iframeEditor0").setValue("${servletURL}?reportlet=demo/analytics/multi_report/all.cpt&__showtoolbar__=false&table=1")]]></Content>
</JavaScript>
</Listener>
<WidgetName name="button0"/>
<WidgetAttr/>
<Text>
<![CDATA[总体概况]]></Text>
</InnerWidget>
<BoundsAttr x="7" y="125" width="80" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.IframeEditor">
<WidgetName name="iframeEditor0"/>
<WidgetAttr/>
<Iframe src="${servletURL}?reportlet=demo/analytics/multi_report/all.cpt&amp;&amp;__showtoolbar__=false" overflowx="true" overflowy="true"/>
<Parameters/>
</InnerWidget>
<BoundsAttr x="7" y="163" width="1150" height="1500"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters>
<Parameter>
<Attributes name="table"/>
<O>
<![CDATA[2]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[this.options.form.getWidgetByName("iframeEditor0").setValue("${servletURL}?reportlet=demo/analytics/multi_report/datetime.cpt&__showtoolbar__=false&table=2")]]></Content>
</JavaScript>
</Listener>
<WidgetName name="button1"/>
<WidgetAttr/>
<Text>
<![CDATA[ 按时间统计]]></Text>
</InnerWidget>
<BoundsAttr x="134" y="125" width="80" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters>
<Parameter>
<Attributes name="table"/>
<O>
<![CDATA[3]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[this.options.form.getWidgetByName("iframeEditor0").setValue("${servletURL}?reportlet=demo/analytics/multi_report/product.cpt&__showtoolbar__=false&table=3") ]]></Content>
</JavaScript>
</Listener>
<WidgetName name="button2"/>
<WidgetAttr/>
<Text>
<![CDATA[按产品统计]]></Text>
</InnerWidget>
<BoundsAttr x="261" y="125" width="80" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters>
<Parameter>
<Attributes name="table"/>
<O>
<![CDATA[4]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[this.options.form.getWidgetByName("iframeEditor0").setValue("${servletURL}?reportlet=demo/analytics/multi_report/district.cpt&__showtoolbar__=false&table=4") ]]></Content>
</JavaScript>
</Listener>
<WidgetName name="button3"/>
<WidgetAttr/>
<Text>
<![CDATA[按地区统计]]></Text>
</InnerWidget>
<BoundsAttr x="381" y="125" width="80" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters>
<Parameter>
<Attributes name="table"/>
<O>
<![CDATA[5]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[this.options.form.getWidgetByName("iframeEditor0").setValue("${servletURL}?reportlet=demo/analytics/multi_report/subcompany.cpt&__showtoolbar__=false&table=5") ]]></Content>
</JavaScript>
</Listener>
<WidgetName name="button4"/>
<WidgetAttr/>
<Text>
<![CDATA[按分公司统计]]></Text>
</InnerWidget>
<BoundsAttr x="502" y="125" width="80" height="21"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.IframeEditor">
<WidgetName name="iframeEditor1"/>
<WidgetAttr/>
<Iframe src="${servletURL}?reportlet=demo/analytics/dashboard/title.cpt&amp;__showtoolbar__=false" overflowx="true" overflowy="true"/>
<Parameters/>
</InnerWidget>
<BoundsAttr x="1" y="4" width="1297" height="121"/>
</Widget>
<LCAttr vgap="0" hgap="0"/>
</Layout>
</Form>
