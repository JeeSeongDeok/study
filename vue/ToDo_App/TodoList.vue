<template>
  <section>
    <transition-group name="list" tag="ul">
      <ul>
        <li v-for="(item, index) in propsdata" v-bind:key="item" v-on:click="editTodo">
          <i class="checkBtn fas fa-check" aria-hidden="true"></i>
          <span class="field-value" v-show="!showField(index)" @click="focusField(index, item)" >{{ item }}</span>
          <input v-model="editItemName" v-show="showField(index)" @keyup.enter="textChange($event, index)" tpye="text" class="FieldValue">
          <span class="removeBtn" type="button" @click="removeTodo(item, index)">
            <i class="far fa-trash-alt" aria-hidden="true"></i>
          </span>
        </li>
      </ul>
    </transition-group>
  </section>
</template>

<script>
export default {
  props: ['propsdata'],
  data () {
    return {
      editField: '',
      editItemName: ''
    }
  },
  methods: {
    focusField (index, item) {
      this.editField = index
      this.editItemName = item
    },
    removeTodo (item, index) {
      this.$emit('removeTodo', item, index)
    },
    showField (index) {
      return (this.editField === index)
    },
    textChange (event, index) {
      this.$emit('textChange', event.currentTarget.value, index)
      this.editField = ''
      this.editItemName = ''
    }
  }
}
</script>

<style scoped>
.list-enter-activie,
.list-leave-active {
  transition: all 1s;
}

.list-enter,
list-leave-to {
  opacity: 0;
  transform: translateY(30px);
}

ul {
  list-style-type: none;
  padding-left: 0px;
  margin-top: 0;
  text-align: left;
}

li {
  display: flex;
  min-height: 50px;
  height: 50px;
  line-height: 50px;
  margin: 0.5rem 0;
  padding: 0, 0.9rem;
  background: white;
  border-radius: 5px;
}

.checkBtn {
  line-height: 45px;
  color: #62acde;
  margin-right: 5px;
}

.removeBtn {
  margin-left: auto;
  color: #de4343
}
</style>
