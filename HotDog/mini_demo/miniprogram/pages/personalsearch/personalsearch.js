// miniprogram/pages/personalsearch/personalsearch.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    toplistTitle:''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },
  goBack: function () {
    wx.navigateBack({
      delta: 1,
    })
  },
  getInputValue(e) {
    wx.setStorageSync('toplistTitle', e.detail.value)
  },
  startSearch: function (e) {
    wx.showModal({
      title: wx.getStorageSync('toplistTitle')+'热榜',
      content: '确认要打开该项吗？',
      success: function (res) {
        if (res.confirm) {
          wx.navigateTo({
            url: '../toplist/toplist',
            success: function (res) { },
            fail: function (res) { },
            complete: function (res) { },
          })
        } else {
          console.log('点击取消回调')
        }
      }
    })
  },
  gotoToplist: function (e) {
    console.log(e.currentTarget.dataset.text)
    wx.setStorageSync('toplistTitle', e.currentTarget.dataset.text)
  }
})