package com.cityinthesky.plugins.mathjax;
 
import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;
import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.util.velocity.VelocityUtils;
import com.atlassian.renderer.v2.components.HtmlEscaper;
import java.util.Map;
 
public class MathDisplayV4 implements Macro
{
    private static final String MACRO_BODY_TEMPLATE = "templates/mathdisplay.vm";

    public MathDisplayV4()
    {
    }
 
    @Override
    public BodyType getBodyType()
    {
        return BodyType.PLAIN_TEXT;
    }
 
    @Override
    public OutputType getOutputType()
    {
        return OutputType.BLOCK;
    }
 
    @Override
    public String execute(Map<String, String> parameters, String bodyContent, ConversionContext conversionContext) 
	throws MacroExecutionException
    {
        Map<String, Object> context = MacroUtils.defaultVelocityContext();
        if (bodyContent.length() == 0) {
            bodyContent = "\\int_{-\\infty}^\\infty \\mbox{e}^{-x^2} \\mbox{d}x = \\sqrt{\\pi}";
        }
	context.put("body", HtmlEscaper.escapeAll(bodyContent, true));
        return VelocityUtils.getRenderedTemplate(MACRO_BODY_TEMPLATE, context);
    }
}
