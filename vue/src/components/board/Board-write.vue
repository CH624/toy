<template>
  <div class="card">
    <b-form id="boardForm">
    <b-card-header>
      <b-card-title>글쓰기</b-card-title>
    </b-card-header>
    <b-card-body>
      <b-form-group>
        <b-input type="text" id="subject" placeholder="제목" autofocus trim min="1"/>
      </b-form-group>
      <b-form-group>
        <b-textarea id="content" placeholder="내용" trim rows="5" max-rows="20"/>
      </b-form-group>
    </b-card-body>
    <b-card-footer>
      <b-button variant="primary" to="/board">목록</b-button>
      <span class="float-right">
        <b-button variant="primary" v-on:click="write">등록</b-button>
        <b-button variant="secondary" type="reset">초기화</b-button>
      </span>
    </b-card-footer>
    </b-form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Board-write',
  methods: {
    write() {
      axios.post('/api/board/info', JSON.stringify({
        subject: document.querySelector('#subject').value,
        content: document.querySelector('#content').value,
      })).then(() => {
        this.$toastr.s('글이 등록되었습니다.')
          .onClosed = () => this.changeShow('list');
      });
    },
  },
};
</script>
