<template>
  <div class='card'>
    <b-card-header>글 목록</b-card-header>
    <b-card-body>
      <b-table sticky-header responsive striped hover show-empty
        :items='items' :fields='fields'
        :sort-by.sync="sortBy" :sort-desc.sync="sortDesc">
        <template v-slot:cell(id)='data'>
          {{data.item.id}}
        </template>
        <template v-slot:cell(subject)="data">
          <router-link :to="/board/ + data.item.id">{{data.item.subject}}</router-link>
        </template>
        <template v-slot:cell(writer)="data">
          {{data.item.writer.name}}
        </template>
        <template v-slot:cell(writeDate)="data">
          {{data.item.writeDate}}
        </template>
      </b-table>
    </b-card-body>
    <b-card-footer>
      <b-button variant="primary" to="/board/write">글쓰기</b-button>
    </b-card-footer>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'Board-list',
  mounted() {
    axios.get('/api/board/info').then(result => (this.items = result.data.content));
  },
  data() {
    return {
      sortBy: 'id',
      sortDesc: true,
      fields: [
        { key: 'id', label: '글번호', sortable: true },
        { key: 'subject', label: '제목' },
        { key: 'writer', label: '작성자' },
        { key: 'writeDate', label: '작성일자' },
      ],
      items: [],
    };
  },
};
</script>
