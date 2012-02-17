package com.cityinthesky.plugins.mathjax;

import java.util.Map;

import com.atlassian.renderer.RenderContext;
import com.atlassian.renderer.v2.macro.BaseMacro;
import com.atlassian.renderer.v2.macro.MacroException;
import com.atlassian.renderer.v2.RenderMode;
import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.util.velocity.VelocityUtils;

public class MathInline extends BaseMacro
{

    private static final String MACRO_BODY_TEMPLATE = "templates/mathinline.vm";

    public MathInline()
    {
    }

    public boolean isInline()
    {
        return false;
    }

    public boolean hasBody()
    {
        return true;
    }

    public RenderMode getBodyRenderMode()
    {
        return RenderMode.NO_RENDER;
    }

    public String execute(Map params, String body, RenderContext renderContext)
            throws MacroException
    {
        Map<String, Object> context = MacroUtils.defaultVelocityContext();
	String newBody = body.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
	context.put("body", newBody);
        return VelocityUtils.getRenderedTemplate(MACRO_BODY_TEMPLATE, context);
    }

}