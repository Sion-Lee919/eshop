<template>

    <v-data-table
        :headers="headers"
        :items="selectProduct"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'SelectProductView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            selectProduct : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/selectProducts'))

            temp.data._embedded.selectProducts.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.selectProduct = temp.data._embedded.selectProducts;
        },
        methods: {
        }
    }
</script>

