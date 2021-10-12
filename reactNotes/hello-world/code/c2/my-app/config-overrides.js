const {
    override,
    disableEsLint,
    addWebpackModuleRule,
    overrideDevServer,
    watchAll
} = require("customize-cra");

module.exports = {
    webpack: override(
        // usual webpack plugin
        disableEsLint(),
        // Adds the provided rule to the webpack config's module.rules array.
        addWebpackModuleRule(
            { // img-loader
                test: /\.(jpe?g|png|gif|svg)$/i,
                use: [
                    'url-loader?limit=10000',
                    'img-loader'
                ]
            }
        ),
    ),
    devServer: overrideDevServer(
        // dev server plugin
        watchAll()
    )
};