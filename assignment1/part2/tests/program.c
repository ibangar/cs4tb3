#include <stdio.h>

/* this is a test prog
 * to demon
 */
int
main(
    int argc,
    char **argv)
{
    /* this is a simple bracket comment */
    int argument1 = 0; // this is a simple eol comment
    int argument2 = 0; //this is also a simple eol comment

    int i;
    for(i = 0; i < argc; i++)
    {
        /* this is a bracket comment */int be_here = 1;//followed by an eol comment
        if (strcmp(argv[i], "-argument1") == 0 && argument1 == 0)
        {
            /* this bracket comment contains eol commments
            printf("you chose argument 1!\n"); // I'm inside a bracket comment!!
            argument1 = 1; // ME TOO!
            */
        }

        /* we are */int i1 = 0;/* consecutive */int i2 = 0;/* bracket comments */int i3 = 0;
        if (strcmp(argv[i], "-argument2") == 0 && argument2 == 0)
        {
            /*imsquished*/
            printf("you chose argument 2!\n");
            /*im followed by code*/int code=1; //    a n d m e eeeee!
            argument2 = 1;
        }

        /* int old_run = 1 */

        int run=1;
        while(run) /* i may run forever, but the comment stripper will not! */
        {
            /*//so//many//slashes!!*/int im_still_here=9001;
            int before_check = 0;  int after_check = 100;
            /***so**many**asterisks***/
            goto end; //jk
        }
    }
    end:
    return 0;
}
