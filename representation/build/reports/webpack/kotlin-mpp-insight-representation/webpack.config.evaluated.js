{
  mode: 'development',
  resolve: {
    modules: [
      'node_modules'
    ]
  },
  plugins: [],
  module: {
    rules: [
      {
        test: /\.js$/,
        use: [
          'source-map-loader'
        ],
        enforce: 'pre'
      },
      {
        test: /\.js$/,
        use: [
          'source-map-loader'
        ],
        enforce: 'pre'
      }
    ]
  },
  entry: [
    '/mnt/d/Projects/kotlin-mpp-insight/build/js/packages/kotlin-mpp-insight-representation/kotlin/kotlin-mpp-insight-representation.js',
    'source-map-support/browser-source-map-support.js'
  ],
  output: {
    path: '/mnt/d/Projects/kotlin-mpp-insight/representation/build/libs',
    filename: 'kotlin-mpp-insight-representation.js'
  },
  devtool: 'eval-source-map'
}