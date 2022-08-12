Vue.component('todo-footer', {
    template: '<div>This is another global child component</div>'
});

var todoList = {
    template: '<div>This is another local child componenet</div>'
};

var app = new Vue({
    el: '#app',
    data: {
        message: 'This is a parent component'
    },
    components: {
        'todo-list': todoList
    }
});
