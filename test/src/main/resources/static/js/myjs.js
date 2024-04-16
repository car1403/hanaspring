    $(document).ready(function(){
      setTimeout(function(){
          $('img').each(function() {
            // http://127.0.0.1:5501/img/mf-icon01.png
            //console.log( this.src );
            if( this.src == '#' ||
                (this.src.includes('http') && !this.src.includes('github.io')) ||
                this.src.includes('cdn')  ){
              //넘어간다.
              return;
            }
            var src = this.src + '';
            var arrayStr = src.split('/img/');
            var orgSrc = '/img/'+arrayStr[1];
            //console.log( orgSrc );
            this.src = '.' + orgSrc;
          });

          $('a').each(function() {
            // http://127.0.0.1:5501/company/company03.html
            //console.log( this.href );
            // 127.0.0.1:5501
            //console.log( window.location.host );
            // /index.html
            // /member/join.html
            //console.log( window.location.pathname );
            if( this.href == '#' ||
                (this.href.includes('http') && !this.href.includes('github.io')) ||
                this.href.includes('cdn')  ){
              //넘어간다.
              return;
            }
            var href = this.href + '';
            var arrayStr = href.split(window.location.host);
            var orgHref = arrayStr[1];
            //console.log( orgHref );
            let pathname = window.location.pathname;
            if( pathname.includes('/member') ||
                pathname.includes('/company') ||
                pathname.includes('/business') ||
                pathname.includes('/product')  ||
                pathname.includes('/community') ||
                pathname.includes('/customer') ) {
              this.href = '../' + orgHref;
            }else{
              this.href = '.' + orgHref;
            }
            //console.log( this.href );
          });

          $('link').each(function() {
            // http://127.0.0.1:5501/css/main.css
            console.log( 'href:'+this.href );
            // 127.0.0.1:5501
            console.log( 'host:'+window.location.host );
            // /index.html
            // /member/join.html
            console.log( 'pathname:'+window.location.pathname );
            
            if( this.href == '#' ||
                (this.href.includes('http') && !this.href.includes('github.io')) ||
                this.href.includes('cdn')  ){
              //넘어간다.
              return;
            }
            var href = this.href + '';
            var arrayStr = href.split(window.location.host);
            var orgHref = arrayStr[1];
            console.log( 'orgHref:'+orgHref );

            let pathname = window.location.pathname;
            if( pathname.includes('/member') ||
                pathname.includes('/company') ||
                pathname.includes('/business') ||
                pathname.includes('/product')  ||
                pathname.includes('/community') ||
                pathname.includes('/customer') ) {
              this.href = '../' + orgHref;
            }else{
              this.href = '.' + orgHref;
            }
            console.log( 'href:'+this.href );
          });

        }, 
        1000
      )
    });