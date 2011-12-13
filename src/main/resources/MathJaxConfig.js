/* Create the necessary configuration section for MathJax */
(function () {
    var configText = 'MathJax.Hub.Config({config: ["MMLorHTML.js"], extensions: ["tex2jax.js","MathZoom.js","MathMenu.js","toMathML.js","TeX/noErrors.js","TeX/noUndefined.js","TeX/AMSmath.js","TeX/AMSsymbols.js"], jax: ["input/TeX","output/HTML-CSS","output/NativeMML"]});';
    var config = document.createElement('script');
    config.type = 'text/x-mathjax-config';
    if (window.opera) {
        config.innerHTML = configText;
    }
    else {
        config.text = configText;
    }
    var scripts = document.getElementsByTagName('script');
    var thisScript = scripts[scripts.length - 1];
    thisScript.parentNode.insertBefore(config, thisScript.nextSibling);
})();
