//index.js

Page({

  /**
   * 页面的初始数据
   */
  data: {
    modalHidden: true
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

  formSubmit: function (e) {
   
      wx.request({
        url: 'https://www.kprun.club/index.php/api/Index/log_on',
        // 访问的域名路径/要绝对路径
        header: {
          "content-type": "application/x-www-form-urlencoded"
        },
        method: "POST",
        data: { username: e.detail.value.username, password: e.detail.value.password },
        success: function (res) {
          
          console.log(res.data);
          if (res.data.code == 0) {
            wx.showToast({
              title: '提交失败！！！',
              icon: 'loading',
              duration: 1500
            })
          } else {
            wx.showToast({
              title: '提交成功！！！',//这里打印出登录成功
              icon: 'success',
              duration: 1000
            })
            wx.setStorageSync('newname', e.detail.value.username);
            console.log(e.detail.value.username);
            wx.navigateTo({
              url: '../personalpage/personalpage',
            })
          }
        }
      })
    

    
  },


  
  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  loginSuccessful: function () {
    wx.showToast({
      title: '登录成功',
      icon: 'succes',
      duration: 1000,
      mask: true
    })
  },/**
   * 显示弹窗
   */
  helpButtonTap: function () {
    this.setData({
      modalHidden: false
    })
  },

  /**
   * 点击取消
   */
  modalCandel: function () {
    // do something
    this.setData({
      modalHidden: true
    })
  },

  /**
   *  点击确认
   */
  modalConfirm: function () {
    // do something
    this.setData({
      modalHidden: true
    })
  }
})