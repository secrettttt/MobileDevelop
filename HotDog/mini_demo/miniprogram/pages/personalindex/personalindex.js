// miniprogram/personalindex/personalindex.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    swiper: {
      imgUrls: [
        '01.jpg',
        '02.jpg',
        '03.jpg'
      ],
      indicatorDots: true,
      autoplay: false,
      interval: 5000,
      duration: 1000,
      current: 0,
    },
  },
  prevImg: function () {
    var swiper = this.data.swiper;
    var current = swiper.current;
    swiper.current = current > 0 ? current - 1 : swiper.imgUrls.length - 1;
    this.setData({
      swiper: swiper,
    })
  },
  nextImg: function () {
    console.log(2);
    var swiper = this.data.swiper;
    var current = swiper.current;
    swiper.current = current < (swiper.imgUrls.length - 1) ? current + 1 : 0;
    this.setData({
      swiper: swiper,
    })
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
  getInputValue(e) {
    wx.setStorageSync('toplistTitle', e.detail.value)
  },
  startSearch: function () {
    wx.navigateTo({
      url: '../toplist/toplist',
      success: function(res) {},
      fail: function(res) {},
      complete: function(res) {},
    })
  },
  gotoToplist: function(e) {
    console.log(e.currentTarget.dataset.text)
    wx.setStorageSync('toplistTitle', e.currentTarget.dataset.text)
  }
})