<?xml version="1.0" encoding="UTF-8"?>
<Form xmlVersion="20120203" releaseVersion="7.0.0">
<DesignAttr width="1059" height="534"/>
<Layout class="com.fr.form.ui.container.WAbsoluteLayout">
<WidgetName name="form"/>
<WidgetAttr/>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.IframeEditor">
<WidgetName name="iframeEditor0"/>
<WidgetAttr/>
<Iframe src="${servletURL}?reportlet=demo/analytics/yibiao.cpt&amp;&amp;__showtoolbar__=false" overflowx="false" overflowy="false"/>
<Parameters/>
</InnerWidget>
<BoundsAttr x="17" y="5" width="482" height="620"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.IframeEditor">
<WidgetName name="iframeEditor1"/>
<WidgetAttr/>
<Iframe src="${servletURL}?reportlet=demo/analytics/sale_month.cpt&amp;&amp;__showtoolbar__=false" overflowx="true" overflowy="true"/>
<Parameters/>
</InnerWidget>
<BoundsAttr x="552" y="71" width="819" height="560"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.IframeEditor">
<WidgetName name="iframeEditor2"/>
<WidgetAttr/>
<Iframe src="${servletURL}?reportlet=demo/analytics/tongji.cpt&amp;&amp;__showtoolbar__=false" overflowx="false" overflowy="false"/>
<Parameters/>
</InnerWidget>
<BoundsAttr x="546" y="5" width="702" height="90"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters>
<Parameter>
<Attributes name="saleman"/>
<O>
<![CDATA[1]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[this.options.form.getWidgetByName("iframeEditor0").setValue("${servletURL}?reportlet=demo/analytics/yibiao.cpt&__showtoolbar__=false&saleman=1")
this.options.form.getWidgetByName("iframeEditor1").setValue("${servletURL}?reportlet=demo/analytics/sale_month.cpt&__showtoolbar__=false&saleman=1")
this.options.form.getWidgetByName("iframeEditor2").setValue("${servletURL}?reportlet=demo/analytics/tongji.cpt&__showtoolbar__=false&saleman=1")]]></Content>
</JavaScript>
</Listener>
<WidgetName name="button0"/>
<WidgetAttr/>
<Text>
<![CDATA[销售员1]]></Text>
</InnerWidget>
<BoundsAttr x="460" y="73" width="80" height="22"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters>
<Parameter>
<Attributes name="saleman"/>
<O>
<![CDATA[2]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[this.options.form.getWidgetByName("iframeEditor0").setValue("${servletURL}?reportlet=demo/analytics/yibiao.cpt&__showtoolbar__=false&saleman=2")
this.options.form.getWidgetByName("iframeEditor1").setValue("${servletURL}?reportlet=demo/analytics/sale_month.cpt&__showtoolbar__=false&saleman=2")
this.options.form.getWidgetByName("iframeEditor2").setValue("${servletURL}?reportlet=demo/analytics/tongji.cpt&__showtoolbar__=false&saleman=2")]]></Content>
</JavaScript>
</Listener>
<WidgetName name="button1"/>
<WidgetAttr/>
<Text>
<![CDATA[销售员2]]></Text>
</InnerWidget>
<BoundsAttr x="460" y="100" width="80" height="22"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters>
<Parameter>
<Attributes name="saleman"/>
<O>
<![CDATA[3]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[this.options.form.getWidgetByName("iframeEditor0").setValue("${servletURL}?reportlet=demo/analytics/yibiao.cpt&__showtoolbar__=false&saleman=3")
this.options.form.getWidgetByName("iframeEditor1").setValue("${servletURL}?reportlet=demo/analytics/sale_month.cpt&__showtoolbar__=false&saleman=3")
this.options.form.getWidgetByName("iframeEditor2").setValue("${servletURL}?reportlet=demo/analytics/tongji.cpt&__showtoolbar__=false&saleman=3")]]></Content>
</JavaScript>
</Listener>
<WidgetName name="button2"/>
<WidgetAttr/>
<Text>
<![CDATA[销售员3]]></Text>
</InnerWidget>
<BoundsAttr x="460" y="127" width="80" height="22"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters>
<Parameter>
<Attributes name="saleman"/>
<O>
<![CDATA[4]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[this.options.form.getWidgetByName("iframeEditor0").setValue("${servletURL}?reportlet=demo/analytics/yibiao.cpt&__showtoolbar__=false&saleman=4")
this.options.form.getWidgetByName("iframeEditor1").setValue("${servletURL}?reportlet=demo/analytics/sale_month.cpt&__showtoolbar__=false&saleman=4")
this.options.form.getWidgetByName("iframeEditor2").setValue("${servletURL}?reportlet=demo/analytics/tongji.cpt&__showtoolbar__=false&saleman=4")]]></Content>
</JavaScript>
</Listener>
<WidgetName name="button3"/>
<WidgetAttr/>
<Text>
<![CDATA[销售员4]]></Text>
</InnerWidget>
<BoundsAttr x="460" y="154" width="80" height="22"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters>
<Parameter>
<Attributes name="saleman"/>
<O>
<![CDATA[5]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[this.options.form.getWidgetByName("iframeEditor0").setValue("${servletURL}?reportlet=demo/analytics/yibiao.cpt&__showtoolbar__=false&saleman=5")
this.options.form.getWidgetByName("iframeEditor1").setValue("${servletURL}?reportlet=demo/analytics/sale_month.cpt&__showtoolbar__=false&saleman=5")
this.options.form.getWidgetByName("iframeEditor2").setValue("${servletURL}?reportlet=demo/analytics/tongji.cpt&__showtoolbar__=false&saleman=5")]]></Content>
</JavaScript>
</Listener>
<WidgetName name="button4"/>
<WidgetAttr/>
<Text>
<![CDATA[销售员5]]></Text>
</InnerWidget>
<BoundsAttr x="460" y="181" width="80" height="22"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters>
<Parameter>
<Attributes name="saleman"/>
<O>
<![CDATA[6]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[this.options.form.getWidgetByName("iframeEditor0").setValue("${servletURL}?reportlet=demo/analytics/yibiao.cpt&__showtoolbar__=false&saleman=6")
this.options.form.getWidgetByName("iframeEditor1").setValue("${servletURL}?reportlet=demo/analytics/sale_month.cpt&__showtoolbar__=false&saleman=6")
this.options.form.getWidgetByName("iframeEditor2").setValue("${servletURL}?reportlet=demo/analytics/tongji.cpt&__showtoolbar__=false&saleman=6")]]></Content>
</JavaScript>
</Listener>
<WidgetName name="button5"/>
<WidgetAttr/>
<Text>
<![CDATA[销售员6]]></Text>
</InnerWidget>
<BoundsAttr x="460" y="208" width="80" height="22"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters>
<Parameter>
<Attributes name="saleman"/>
<O>
<![CDATA[7]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[this.options.form.getWidgetByName("iframeEditor0").setValue("${servletURL}?reportlet=demo/analytics/yibiao.cpt&__showtoolbar__=false&saleman=7")
this.options.form.getWidgetByName("iframeEditor1").setValue("${servletURL}?reportlet=demo/analytics/sale_month.cpt&__showtoolbar__=false&saleman=7")
this.options.form.getWidgetByName("iframeEditor2").setValue("${servletURL}?reportlet=demo/analytics/tongji.cpt&__showtoolbar__=false&saleman=7")]]></Content>
</JavaScript>
</Listener>
<WidgetName name="button6"/>
<WidgetAttr/>
<Text>
<![CDATA[销售员7]]></Text>
</InnerWidget>
<BoundsAttr x="460" y="235" width="80" height="22"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters>
<Parameter>
<Attributes name="saleman"/>
<O>
<![CDATA[8]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[this.options.form.getWidgetByName("iframeEditor0").setValue("${servletURL}?reportlet=demo/analytics/yibiao.cpt&__showtoolbar__=false&saleman=8")
this.options.form.getWidgetByName("iframeEditor1").setValue("${servletURL}?reportlet=demo/analytics/sale_month.cpt&__showtoolbar__=false&saleman=8")
this.options.form.getWidgetByName("iframeEditor2").setValue("${servletURL}?reportlet=demo/analytics/tongji.cpt&__showtoolbar__=false&saleman=8")]]></Content>
</JavaScript>
</Listener>
<WidgetName name="button7"/>
<WidgetAttr/>
<Text>
<![CDATA[销售员8]]></Text>
</InnerWidget>
<BoundsAttr x="460" y="261" width="80" height="22"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters>
<Parameter>
<Attributes name="saleman"/>
<O>
<![CDATA[9]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[this.options.form.getWidgetByName("iframeEditor0").setValue("${servletURL}?reportlet=demo/analytics/yibiao.cpt&__showtoolbar__=false&saleman=9")
this.options.form.getWidgetByName("iframeEditor1").setValue("${servletURL}?reportlet=demo/analytics/sale_month.cpt&__showtoolbar__=false&saleman=9")
this.options.form.getWidgetByName("iframeEditor2").setValue("${servletURL}?reportlet=demo/analytics/tongji.cpt&__showtoolbar__=false&saleman=9")]]></Content>
</JavaScript>
</Listener>
<WidgetName name="button8"/>
<WidgetAttr/>
<Text>
<![CDATA[销售员9]]></Text>
</InnerWidget>
<BoundsAttr x="460" y="288" width="80" height="22"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters>
<Parameter>
<Attributes name="saleman"/>
<O>
<![CDATA[10]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[this.options.form.getWidgetByName("iframeEditor0").setValue("${servletURL}?reportlet=demo/analytics/yibiao.cpt&__showtoolbar__=false&saleman=10")
this.options.form.getWidgetByName("iframeEditor1").setValue("${servletURL}?reportlet=demo/analytics/sale_month.cpt&__showtoolbar__=false&saleman=10")
this.options.form.getWidgetByName("iframeEditor2").setValue("${servletURL}?reportlet=demo/analytics/tongji.cpt&__showtoolbar__=false&saleman=10")]]></Content>
</JavaScript>
</Listener>
<WidgetName name="button9"/>
<WidgetAttr/>
<Text>
<![CDATA[销售员10]]></Text>
</InnerWidget>
<BoundsAttr x="460" y="315" width="80" height="22"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters>
<Parameter>
<Attributes name="saleman"/>
<O>
<![CDATA[11]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[this.options.form.getWidgetByName("iframeEditor0").setValue("${servletURL}?reportlet=demo/analytics/yibiao.cpt&__showtoolbar__=false&saleman=11")
this.options.form.getWidgetByName("iframeEditor1").setValue("${servletURL}?reportlet=demo/analytics/sale_month.cpt&__showtoolbar__=false&saleman=11")
this.options.form.getWidgetByName("iframeEditor2").setValue("${servletURL}?reportlet=demo/analytics/tongji.cpt&__showtoolbar__=false&saleman=11")]]></Content>
</JavaScript>
</Listener>
<WidgetName name="button10"/>
<WidgetAttr/>
<Text>
<![CDATA[销售员11]]></Text>
</InnerWidget>
<BoundsAttr x="460" y="342" width="80" height="23"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters>
<Parameter>
<Attributes name="saleman"/>
<O>
<![CDATA[12]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[this.options.form.getWidgetByName("iframeEditor0").setValue("${servletURL}?reportlet=demo/analytics/yibiao.cpt&__showtoolbar__=false&saleman=12")
this.options.form.getWidgetByName("iframeEditor1").setValue("${servletURL}?reportlet=demo/analytics/sale_month.cpt&__showtoolbar__=false&saleman=12")
this.options.form.getWidgetByName("iframeEditor2").setValue("${servletURL}?reportlet=demo/analytics/tongji.cpt&__showtoolbar__=false&saleman=12")]]></Content>
</JavaScript>
</Listener>
<WidgetName name="button11"/>
<WidgetAttr/>
<Text>
<![CDATA[销售员12]]></Text>
</InnerWidget>
<BoundsAttr x="460" y="370" width="80" height="22"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters>
<Parameter>
<Attributes name="saleman"/>
<O>
<![CDATA[13]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[this.options.form.getWidgetByName("iframeEditor0").setValue("${servletURL}?reportlet=demo/analytics/yibiao.cpt&__showtoolbar__=false&saleman=13")
this.options.form.getWidgetByName("iframeEditor1").setValue("${servletURL}?reportlet=demo/analytics/sale_month.cpt&__showtoolbar__=false&saleman=13")
this.options.form.getWidgetByName("iframeEditor2").setValue("${servletURL}?reportlet=demo/analytics/tongji.cpt&__showtoolbar__=false&saleman=13")]]></Content>
</JavaScript>
</Listener>
<WidgetName name="button12"/>
<WidgetAttr/>
<Text>
<![CDATA[销售员13]]></Text>
</InnerWidget>
<BoundsAttr x="460" y="396" width="80" height="22"/>
</Widget>
<Widget class="com.fr.form.ui.container.WAbsoluteLayout$BoundsWidget">
<InnerWidget class="com.fr.form.ui.FreeButton">
<Listener event="click">
<JavaScript class="com.fr.base.js.JavaScriptImpl">
<Parameters>
<Parameter>
<Attributes name="saleman"/>
<O>
<![CDATA[14]]></O>
</Parameter>
</Parameters>
<Content>
<![CDATA[this.options.form.getWidgetByName("iframeEditor0").setValue("${servletURL}?reportlet=demo/analytics/yibiao.cpt&__showtoolbar__=false&saleman=14")
this.options.form.getWidgetByName("iframeEditor1").setValue("${servletURL}?reportlet=demo/analytics/sale_month.cpt&__showtoolbar__=false&saleman=14")
this.options.form.getWidgetByName("iframeEditor2").setValue("${servletURL}?reportlet=demo/analytics/tongji.cpt&__showtoolbar__=false&saleman=14")]]></Content>
</JavaScript>
</Listener>
<WidgetName name="button13"/>
<WidgetAttr/>
<Text>
<![CDATA[销售员14]]></Text>
</InnerWidget>
<BoundsAttr x="460" y="424" width="80" height="22"/>
</Widget>
<LCAttr vgap="0" hgap="0"/>
</Layout>
</Form>
