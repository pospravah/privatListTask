import React from "react";
import ReactDom from "react-dom";
import MainApp from "./componenets/main_component";

class App extends React.Component {

render() {
return <div>
        <p>Hello, Next one is MainApp!</p>
        <MainApp />
    </div>
    }
}

ReactDom.render(<App />, document.getElementById('react'));
