

Vue.component('sibling-component', {
    props: ['sibling'],
    template: '<p>{{ sibling}}</p>'
});

Vue.component('child-component', {
    props: ['propsdata'],
    template: '<p>{{ propsdata }}</p>'
});



var app = new Vue({
    el:'#app',
    data: {
        message: 'Hello Vue',
        anotherMessage: "Hello Hello"
    }
});
