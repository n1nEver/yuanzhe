

    function link_recruits_edit() {
        document.getElementById('wantting_show').style.display = "none";
        document.getElementById('recruits_edit').style.display = "block";
    }

    function link_wantting_show() {
        document.getElementById('wantting_show').style.display = "block";
        document.getElementById('recruits_edit').style.display = "none";
    }

    function link_reg_user() {
        document.getElementById('user_reg_div').style.display = "block";
        document.getElementById('cmp_reg_div').style.display = "none";
    }

    function link_reg_cmp() {
        document.getElementById('user_reg_div').style.display = "none";
        document.getElementById('cmp_reg_div').style.display = "block";
    }

    function link_user_info_edit () {
        console.log(1)

        document.getElementById('user_edit_div_id').style.display = "block";
        document.getElementById('user_chpw_div_id').style.display = "none";
        document.getElementById('user_info_div_id').style.display = "none";
    }


    function link_user_info_chpw () {
        console.log(2)

        document.getElementById('user_chpw_div_id').style.display = "block";
        document.getElementById('user_info_div_id').style.display = "none";
        document.getElementById('user_edit_div_id').style.display = "none";
    }

    function link_user_info_show () {
        console.log(3)

        document.getElementById('user_info_div_id').style.display = "block";
        document.getElementById('user_edit_div_id').style.display = "none";
        document.getElementById('user_chpw_div_id').style.display = "none";

    }

    function link_login_cmp () {
        document.getElementById('usr').style.display = "none";
        document.getElementById('cmp').style.display = "block";
        console.log(1)
    }

    function link_login_user() {
        document.getElementById('usr').style.display = "block";
        document.getElementById('cmp').style.display = "none";
    }

    function changeImage() {
        document.getElementById("imageCode1").src=document.getElementById("imageCode2").src="checkcode?"+new Date().getTime();
    }

    function mOver(obj)
    {
        obj.style.overflow = "visible";
    }

    function mOut(obj)
    {
        obj.style.overflow = "hidden";
    }


    function link_login_user() {
        document.getElementById('usr').style.display = "block";
        document.getElementById('cmp').style.display = "none";
    }
    
    function link_msg_show() {
        document.getElementById('msg_show_div').style.display = "block";
        document.getElementById('msg_edit_div').style.display = "none";
    }
    
    function link_msg_edit() {
        document.getElementById('msg_show_div').style.display = "none";
        document.getElementById('msg_edit_div').style.display = "block";
    }

