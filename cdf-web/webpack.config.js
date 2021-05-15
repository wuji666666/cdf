
const path=require('path')

const htmlWebpackPlugin=require('html-webpack-plugin')
const loader = require('sass-loader')

const VueLoaderPlugin=require('vue-loader/lib/plugin')
const { options } = require('less')

const webpack=require('webpack')


 

module.exports={

    entry:path.join(__dirname,'./src/main.js'),
    output:{
        path:path.join(__dirname,'./dist'),
        filename:'bundle.js'
    },
    mode:'production',
    plugins:[
        new htmlWebpackPlugin({
        template:path.join(__dirname,'./src/index.html'), 
        filename:'index.html'
        }),
        new VueLoaderPlugin(),
        new webpack.ProvidePlugin({
            $:"jquery",
            jQuery:"jquery",
          })

    ],

    module:{
        rules:[
            {test: /\.css$/, use: ['style-loader','css-loader']},
            {test: /\.less$/, use: ['style-loader', 'css-loader','less-loader']},
            {test: /\.scss$/, use: ['style-loader', 'css-loader', 'sass-loader']},
            {test: /\.(jpg|png|gif|bmp|jpeg)$/, use:[{loader:'url-loader?limit:7361 & name=[hash:8]-[name].[ext]',options:{esModule: false}
            }]},
            {test: /\.(ttf|eot|svg|woff|woff2)$/, use: ['url-loader']},         
            {test: /\.js$/, use: 'babel-loader', exclude: /node_modules/},
            {test: /\.vue$/,  use: 'vue-loader'},
        ]
    },

   /* devServer: {
        host: "localhost",
        port: 8088,
        proxy: {
            '/cdf': {
                target: 'http://localhost:8080',
                changeOrigin: true,
            }
        }
    }*/

    performance: {
 
        hints: "warning", // 枚举
         
        maxAssetSize: 400000, // 整数类型（以字节为单位）
         
        maxEntrypointSize: 600000, // 整数类型（以字节为单位）
         
        assetFilter: function(assetFilename) {
         
        // 提供资源文件名的断言函数
         
        return assetFilename.endsWith('.css') || assetFilename.endsWith('.js');
         
        }
         
        },


   
   


}
