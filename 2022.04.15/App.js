import * as React from "react";
import { BackHandler, ToastAndroid } from "react-native";
import { WebView } from "react-native-webview";

export default class App extends React.Component {
    disableBackButton = () => {
        if (this.exitApp == undefined || !this.exitApp) {
            ToastAndroid.show(
                "한번 더 누르시면 종료됩니다.",
                ToastAndroid.SHORT
            );
            this.exitApp = true;

            this.timeout = setTimeout(
                () => {
                    this.exitApp = false;
                },
                2000 // 2초
            );
        } else {
            clearTimeout(this.timeout);

            BackHandler.exitApp(); // 앱 종료
        }
        return true;
    };
    componentDidMount() {
        BackHandler.addEventListener(
            "hardwareBackPress",
            this.disableBackButton
        );
    }
    componentWillUnmount() {
        this.exitApp = false;
        BackHandler.addEventListener(
            "hardwareBackPress",
            this.disableBackButton
        );
    }
    render() {
        return (
            <WebView
                source={{ uri: "https://qrscaner.netlify.app/" }}
                style={{ marginTop: 20 }}
            />
        );
    }
}
