// miniprogram/pages/join/join.js
Page({

  /**
   * 页面的初始数据
   */
  data: {

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
    console.log(e.detail.value);
    wx.request({
      url: 'https://www.kprun.club/index.php/api/Index/log_in',
            // 访问的域名路径/要绝对路径
      header: {
        "Content-Type": "application/x-www-form-urlencoded"
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
          wx.navigateTo({
            url: '../index/index',
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

  joinSuccessful: function () {
    wx.showToast({
      title: '注册成功',
      icon: 'succes',
      duration: 1000,
      mask: true
    })
  },
  contactUs:function(){
    wx.showActionSheet({
      itemList: ['电话联系', '微信联系', '发个邮件'],
      success: function (res) {
        console.log(res.tapIndex)
        if(res.tapIndex==0){
          wx.makePhoneCall({
            phoneNumber: '18878577727' //客服电话
          })
        }
        else if(res.tapIndex==1){
          wx.showModal({
            title: '微信联系',
            content: 'wangji243950547',
            success: function (res) {
              if (res.confirm) {
                console.log('用户点击确定')
              } else if (res.cancel) {
                console.log('用户点击取消')
              }
            }
          })
        }
        else{
          wx.showModal({
            title: '发个邮箱',
            content: 'secrettttt@pku.edu.cn',
            success: function (res) {
              if (res.confirm) {
                console.log('用户点击确定')
              } else if (res.cancel) {
                console.log('用户点击取消')
              }
            }
          })
        }
      },
      fail: function (res) {
        console.log(res.errMsg)
      }
    })
  }  
})