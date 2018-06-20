var feedback = function(res) {
    if (res.success === true) {
        var get_link = res.data.link.replace(/^http:\/\//i, 'https://');
        document.querySelector('.status').classList.add('bg-success');
        
        if(document.getElementById('imagelink') == null)
        	document.querySelector('.status').innerHTML =
            /*'Image : ' + */'<br><input id="imagelink" class="image-url" value="" type="hidden"/>';// + '<img class="img" alt="Imgur-Upload" src=\"' + get_link + '\"/>';
        var tf = document.getElementById('imagelink');	
        tf.value = tf.value+';'+get_link;
    }
};

new Imgur({
    clientid: 'f8462b413c60c3e', 
    callback: feedback
});