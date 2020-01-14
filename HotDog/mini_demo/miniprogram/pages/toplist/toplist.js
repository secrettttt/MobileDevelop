// miniprogram/pages/personalsearch/personalsearch.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    toplistTitle: '',
    list: [],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var toplistTitle = wx.getStorageSync('toplistTitle')
    this.setData({
      toplistTitle: toplistTitle
    })
    var that = this//不要漏了这句，很重要
    wx.request({
      url: 'https://www.tophub.fun:8080/GetType',
      headers: {
        'Content-Type': 'application/json'
      },
      success: function (res) {

        var json1 = res.data.Data
        console.log(json1);
        for (var i = 0; i < json1.length; i++) {
          for (var j in json1[i]) {
            if (json1[i][j] === toplistTitle) {
              console.log(toplistTitle);

              var id = json1[i]["id"]
              app.globalData.key = id
            }
          }
        }

        wx.request({
          url: 'https://www.tophub.fun:8080/GetAllInfoGzip?id=' + id,

          headers: {
            'Content-Type': 'application/json'
          },
          success: function (res) {
            that.setData({
              list: res.data.Data,
              //res代表success函数的事件对，data是固定的，fengxiang是是上面json数据中fengxiang
            })
          }
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  toOut: (event) => {
    console.log(event.currentTarget.dataset.variable);
    console.log(typeof event.currentTarget.dataset.variable);
    var temp = event.currentTarget.dataset.variable;
    wx.navigateTo({
      url: '../out/out?temp=' + event.currentTarget.dataset.variable,
    })
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  goBack: function () {
    wx.navigateBack({
      delta: 1,
    })
  }
})