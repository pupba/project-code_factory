import wikipediaapi
import wikipedia

wiki=wikipediaapi.Wikipedia('ko') # ko-wikipedia site setting
name = input("무엇을 검색할 까요? ---> ")
wikipedia.set_lang('ko') # wikipedia setting language to korean

wikiPage = wiki.page(name) # search 
imgSrc = wikipedia.page(name).images[0] # image url search
summary = wikiPage.summary # summary
processingSummary = summary.replace('.','.<br>').strip()
htmlFile  = f"""
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>{name}</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Jua&display=swap');
        body{{
            font-family: 'Jua', sans-serif;
            height: 100%;
            text-align: center;
        }}
        #border{{
            background-image: url("https://us.123rf.com/450wm/apostrophe/apostrophe1601/apostrophe160100028/51329148-%EB%B3%B4%EB%9D%BC%EC%83%89-%EB%B6%84%ED%99%8D%EC%83%89-%EB%B0%8F-%ED%8C%8C%EB%9E%91-%EB%B0%B0%EA%B2%BD-%EA%B7%B8%EB%9D%BC%EB%8D%B0%EC%9D%B4%EC%85%98-%EC%83%89-%EB%B0%8F-grunge-%EB%B9%88%ED%8B%B0%EC%A7%80-%ED%85%8D%EC%8A%A4%EC%B2%98.jpg?ver=6");
            background-size: cover;
            height: 60em;
            width: 70em;
            margin: auto;
            border-radius: 10px;
            box-shadow: 0 5px 10px rgba(0, 0, 0, 0.664);
        }}
        header{{
            margin-top: 5em;
            height: 5em;
        }}
        h1{{
            font-size: 4em;
            color: indigo;
        }}
        img{{
            height: 18em;
            margin: 1.5em;
            border-radius: 7px;
            box-shadow: 0 7px 15px rgba(0, 0, 0, 0.664);
        }}
        table{{
            margin:auto;
        }}
        th{{
            text-align: left;
            font-size: 1.8em;
            color : rgba(20, 20, 19, 0.774);
        }}
        section{{
            height: 5em;
        }}
        address{{
            height : 2em;
            margin-top: 1em;
            font-size: 2em;
            color : rgba(20, 20, 19, 0.774);
        }}
        a:link{{
            color : rgba(20, 20, 19, 0.774);
            text-decoration: none;
        }}
        a:visited{{
            color : rgba(20, 20, 19, 0.774);
            text-decoration: none;
        }}
        a:hover{{
            color:aqua;
            text-decoration: none;
            transition: color 1s ease-in-out;
        }}
    </style>
</head>
<body>
    <div id="border">
        <header><h1>{name}</h1></header>
        <section>
            <article>
                <img src="{imgSrc}",alt="{name}"><br>
                <table>
                    <tr>
                        <th>
                            {processingSummary}
                        </th>
                    </tr>
                </table>
            </article>
            <address>
                <cite>
                    출처-<a href="https://ko.wikipedia.org/wiki/{name}">
                        위키백과-{name}
                    </a>
                </cite> 
            </address>
        </section>
    </div>
</body>
</html>
"""
fileName = f"{name}.html" 
with open(f"./{fileName}",'w',encoding="utf8") as f:
     f.write(htmlFile)
     print("페이지 생성 완료!")
